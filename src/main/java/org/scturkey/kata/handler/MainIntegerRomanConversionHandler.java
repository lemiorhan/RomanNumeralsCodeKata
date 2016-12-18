package org.scturkey.kata.handler;

import org.scturkey.kata.ConversionResult;
import org.scturkey.kata.IntegerToRomanNumberMapping;

public class MainIntegerRomanConversionHandler implements RomanConversionHandler {

    private RomanConversionHandler successor;

    @Override
    public void handle(ConversionResult result) {
        if (result.romanNumber() != null) return;

        if (IntegerToRomanNumberMapping.isMainNumber(result.integerNumber()))
            result.setRomanNumber(IntegerToRomanNumberMapping.romanRepresentationOf(result.integerNumber()));
        if (successor != null) successor.handle(result);
    }

    @Override
    public void setSuccessor(RomanConversionHandler handler) {
        successor = handler;
    }
}
