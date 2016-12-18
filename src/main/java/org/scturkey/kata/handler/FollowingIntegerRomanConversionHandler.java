package org.scturkey.kata.handler;

import org.scturkey.kata.ConversionResult;
import org.scturkey.kata.IntegerToRomanNumberMapping;

public class FollowingIntegerRomanConversionHandler implements RomanConversionHandler {

    private RomanConversionHandler successor;

    public String convert(int input, int integerNumber) {
        if (input / 1000 == 2 || input / 1000 == 3) {
            return append(input, integerNumber, 1000);
        } else if (input / 10 == 2 || input / 10 == 3) {
            return append(input, integerNumber, 10);
        } else if (input / 100 == 2 || input / 100 == 3) {
            return append(input, integerNumber, 100);
        } else if (input > 500) {
            return append(input, integerNumber, 100);
        } else if (input > 50) {
            return append(input, integerNumber, 10);
        } else if (input > 1) {
            return append(input, integerNumber, 1);
        }
        return "";
    }

    public String append(int input, int integerNumber, int divisor) {
        StringBuilder fsb = new StringBuilder();
        if (input > integerNumber) {
            fsb.append(IntegerToRomanNumberMapping.romanRepresentationOf(integerNumber));
            for (int i = 0; i < (input - integerNumber) / divisor; i++) {
                fsb.append(IntegerToRomanNumberMapping.romanRepresentationOf(divisor));
            }
        }
        return fsb.toString();
    }

    @Override
    public void handle(ConversionResult result) {
        if (result.romanNumber() != null) return;

        for (Integer mainInteger : IntegerToRomanNumberMapping.mainIntegers()) {
            if (result.integerNumber() > mainInteger) {
                result.setRomanNumber(convert(result.integerNumber(), mainInteger));
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
