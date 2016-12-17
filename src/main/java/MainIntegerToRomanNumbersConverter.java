
public class MainIntegerToRomanNumbersConverter {

    private IntegerToRomanNumberMapping mapping;

    public MainIntegerToRomanNumbersConverter(IntegerToRomanNumberMapping mapping) {
        this.mapping = mapping;
    }

    public String convert(int input) {
        if (mapping.isMainNumber(input))
            return mapping.romanRepresentationOf(input);
        return null;
    }
}
