package org.scturkey.kata;

import org.scturkey.kata.handler.FollowingIntegerRomanConversionHandler;
import org.scturkey.kata.handler.MainIntegerRomanConversionHandler;
import org.scturkey.kata.handler.RomanConversionHandler;
import org.scturkey.kata.handler.TrainingIntegerRomanConversionHandler;

public class IntegerToRomanNumberConverter {

    private DecimalDigitsSplitter splitter;
    private IntegerToRomanNumberMapping mapping;

    public IntegerToRomanNumberConverter(DecimalDigitsSplitter splitter) {
        this.splitter = splitter;
        mapping = new IntegerToRomanNumberMapping();
    }

    public String convert(int input) {
        StringBuilder sb = new StringBuilder();
        for (Integer digit : splitter.split(input)) {
            if (digit != 0) sb.append(convertDigit(digit));
        }
        return sb.toString();
    }

    public String convertDigit(int input) {
        RomanConversionHandler step1 = new MainIntegerRomanConversionHandler(mapping);
        RomanConversionHandler step2 = new TrainingIntegerRomanConversionHandler(mapping);
        RomanConversionHandler step3 = new FollowingIntegerRomanConversionHandler(mapping);

        step1.setSuccessor(step2);
        step2.setSuccessor(step3);

        ConversionResult result = new ConversionResult();
        result.integerNumber = input;

        step1.handle(result);
        return result.romanNumber;
    }

}