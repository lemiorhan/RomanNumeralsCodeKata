import java.util.Map;

public class IntegerToRomanNumberConverter {

    private DecimalDigitsSplitter splitter;
    private IntegerToRomanNumberMapping mapping;

    public IntegerToRomanNumberConverter(DecimalDigitsSplitter splitter) {
        this.splitter = splitter;
        mapping = new IntegerToRomanNumberMapping();
    }

    public String convert(int input) {
        StringBuilder sb = new StringBuilder();
        for (Integer digit : splitter.split(input)) {
            if (digit != 0) sb.append(convertDigit(digit));
        }
        return sb.toString();
    }

    public String convertDigit(int input) {
        String romanNumber = new MainIntegerToRomanNumbersConverter(mapping).convert(input);
        if (romanNumber != null) return romanNumber;

        romanNumber = new TrainingIntegerToRomanNumberConverter(mapping).convert(input);
        if (romanNumber != null) return romanNumber;

        romanNumber = new FollowingIntegerToRomanNumberConverter(mapping).convert(input);
        if (romanNumber != null) return romanNumber;

        throw new RuntimeException("Unable to convert");
    }

}
