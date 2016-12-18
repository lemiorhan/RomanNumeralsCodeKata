package org.scturkey.kata.handler;

import org.scturkey.kata.ConversionResult;

import java.util.ArrayList;
import java.util.List;

public class RomanConversionHandlerRegistry {

    List<RomanConversionHandler> registry = new ArrayList<>();

    public void register(RomanConversionHandler handler) {
        registry.add(handler);
    }

    public void execute(ConversionResult result) {
        RomanConversionHandler firstHandler = null;
        RomanConversionHandler prevHandler = null;

        for (RomanConversionHandler handler : registry) {
            if (firstHandler == null) firstHandler = handler;
            if (prevHandler != null) {
                prevHandler.setSuccessor(handler);
            }
            prevHandler = handler;
        }
        firstHandler.handle(result);
    }
}
