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
        if (mapping.isMainNumber(input))
            return mapping.romanRepresentationOf(input);

        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input == mainInteger - mapping.divisorOf(mainInteger)) {
                return appendForTrailingNumber(input);
            }
        }

        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input > mainInteger) {
                return appendForFollowingNumber(input, mainInteger);
            }
        }

        throw new RuntimeException("Unable to convert");
    }

    public String appendForTrailingNumber(int input) {
        StringBuilder fsb = new StringBuilder();
        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input == mainInteger - mapping.divisorOf(mainInteger)) {
                fsb.append(mapping.romanRepresentationOf(mapping.divisorOf(mainInteger))).append(mapping.romanRepresentationOf(mainInteger));
                break;
            }
        }
        return fsb.toString();
    }

    public String appendForFollowingNumber(int input, int integerNumber) {
        if (input / 1000 == 2 || input / 1000 == 3) {
            return append(input, integerNumber, 1000);
        }
        else if (input / 10 == 2 || input / 10 == 3) {
            return append(input, integerNumber, 10);
        }
        else if (input / 100 == 2 || input / 100 == 3) {
            return append(input, integerNumber, 100);
        }
        else if (input > 500) {
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
            fsb.append(mapping.romanRepresentationOf(integerNumber));
            for (int i = 0; i < (input - integerNumber) / divisor; i++) {
                fsb.append(mapping.romanRepresentationOf(divisor));
            }
        }
        return fsb.toString();
    }

}
