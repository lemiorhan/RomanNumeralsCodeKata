
public class FollowingIntegerToRomanNumberConverter {

    private IntegerToRomanNumberMapping mapping;

    public FollowingIntegerToRomanNumberConverter(IntegerToRomanNumberMapping mapping) {
        this.mapping = mapping;
    }

    public String convert(int input) {
        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input > mainInteger) {
                return appendForFollowingNumber(input, mainInteger);
            }
        }
        return null;
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
