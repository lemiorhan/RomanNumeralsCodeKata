package org.scturkey.kata;

import org.scturkey.kata.handler.*;

public class IntegerToRomanNumberConverter {

    public String convert(int input) {
        StringBuilder sb = new StringBuilder();
        for (Integer digit : DecimalDigitsSplitter.split(input)) {
            sb.append(convertDigit(digit));
        }
        return sb.toString();
    }

    private String convertDigit(Integer digit) {
        return DecimalDigitsSplitter.isValidDigit(digit) ? applyConversionAlgorithms(digit) : "";
    }

    private String applyConversionAlgorithms(int input) {
        RomanConversionHandlerRegistry registry = new RomanConversionHandlerRegistry();
        registry.register(new MainIntegerRomanConversionHandler());
        registry.register(new TrainingIntegerRomanConversionHandler());
        registry.register(new FollowingIntegerRomanConversionHandler());

        ConversionResult result = new ConversionResult(input);

        registry.execute(result);
        return result.romanNumber();
    }

}
