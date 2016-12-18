package org.scturkey.kata;

public class ConversionResult {

    private int integerNumber;
    private String romanNumber;

    public ConversionResult(int integerNumber) {
        this.integerNumber = integerNumber;
    }

    public int integerNumber() {
        return integerNumber;
    }

    public String romanNumber() {
        return romanNumber;
    }

    public void setRomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

}
