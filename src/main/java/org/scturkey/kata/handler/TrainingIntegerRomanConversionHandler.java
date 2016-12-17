package org.scturkey.kata.handler;

import org.scturkey.kata.ConversionResult;
import org.scturkey.kata.IntegerToRomanNumberMapping;

public class TrainingIntegerRomanConversionHandler implements RomanConversionHandler {
    IntegerToRomanNumberMapping mapping;
    private RomanConversionHandler successor;


    public TrainingIntegerRomanConversionHandler(IntegerToRomanNumberMapping mapping) {
        this.mapping = mapping;
    }

    public String appendForTrailingNumber(int input) {
        StringBuilder fsb = new StringBuilder();
        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input == mainInteger - mapping.divisorOf(mainInteger)) {
                fsb.append(mapping.romanRepresentationOf(mapping.divisorOf(mainInteger))).append(mapping.romanRepresentationOf(mainInteger));
                break;
            }
        }
        return fsb.toString();
    }

    @Override
    public void handle(ConversionResult result) {
        if (result.romanNumber != null) return;

        for (Integer mainInteger : mapping.mainIntegers()) {
            if (result.integerNumber == mainInteger - mapping.divisorOf(mainInteger)) {
                result.romanNumber = appendForTrailingNumber(result.integerNumber);
                break;
            }
        }
        if (successor != null) successor.handle(result);
    }

    @Override
    public void setSuccessor(RomanConversionHandler handler) {
        successor = handler;
    }
}
