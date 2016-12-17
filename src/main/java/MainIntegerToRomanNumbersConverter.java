
public class MainIntegerToRomanNumbersConverter implements RomanConversionHandler {

    private IntegerToRomanNumberMapping mapping;
    private RomanConversionHandler successor;

    public MainIntegerToRomanNumbersConverter(IntegerToRomanNumberMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public void handle(ConversionResult result) {
        if (result.romanNumber != null) return;

        if (mapping.isMainNumber(result.integerNumber))
            result.romanNumber = mapping.romanRepresentationOf(result.integerNumber);
        if (successor != null) successor.handle(result);
    }

    @Override
    public void setSuccessor(RomanConversionHandler handler) {
        successor = handler;
    }
}
