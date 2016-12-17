
interface RomanConversionHandler {
    void handle(ConversionResult result);
    void setSuccessor(RomanConversionHandler handler);
}

