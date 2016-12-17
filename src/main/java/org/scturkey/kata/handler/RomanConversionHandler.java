package org.scturkey.kata.handler;

import org.scturkey.kata.ConversionResult;

public interface RomanConversionHandler {
    void handle(ConversionResult result);
    void setSuccessor(RomanConversionHandler handler);
}

