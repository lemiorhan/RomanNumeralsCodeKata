package org.scturkey.kata.handler;

import org.scturkey.kata.ConversionResult;
import org.scturkey.kata.IntegerToRomanNumberMapping;

public class TrainingIntegerRomanConversionHandler implements RomanConversionHandler {
    private RomanConversionHandler successor;

    public String appendForTrailingNumber(int input) {
        StringBuilder fsb = new StringBuilder();
        for (Integer mainInteger : IntegerToRomanNumberMapping.mainIntegers()) {
            if (input == mainInteger - IntegerToRomanNumberMapping.divisorOf(mainInteger)) {
                fsb.append(IntegerToRomanNumberMapping.romanRepresentationOf(IntegerToRomanNumberMapping.divisorOf(mainInteger))).append(IntegerToRomanNumberMapping.romanRepresentationOf(mainInteger));
                break;
            }
        }
        return fsb.toString();
    }

    @Override
    public void handle(ConversionResult result) {
        if (result.romanNumber() != null) return;

        for (Integer mainInteger : IntegerToRomanNumberMapping.mainIntegers()) {
            if (result.integerNumber() == mainInteger - IntegerToRomanNumberMapping.divisorOf(mainInteger)) {
                result.setRomanNumber(appendForTrailingNumber(result.integerNumber()));
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
