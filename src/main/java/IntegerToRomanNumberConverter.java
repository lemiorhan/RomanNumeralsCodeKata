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
        RomanConversionHandler step1 = new MainIntegerToRomanNumbersConverter(mapping);
        RomanConversionHandler step2 = new TrainingIntegerToRomanNumberConverter(mapping);
        RomanConversionHandler step3 = new FollowingIntegerToRomanNumberConverter(mapping);

        step1.setSuccessor(step2);
        step2.setSuccessor(step3);

        ConversionResult result = new ConversionResult();
        result.integerNumber = input;

        step1.handle(result);
        return result.romanNumber;
    }

}
