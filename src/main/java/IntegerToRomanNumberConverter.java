import java.util.Map;

public class IntegerToRomanNumberConverter {

    Map<Integer, String> mainNumberMapping;
    private StringBuilder sb;

    public IntegerToRomanNumberConverter(Map<Integer, String> mainNumberMapping) {
        this.mainNumberMapping = mainNumberMapping;
    }

    public String convert(int input) {
        sb = new StringBuilder();

        if (isMainNumber(input))
            return romanRepresentationOf(input);

        for (Map.Entry entry : mainNumberMapping.entrySet()) {
            if (input > (Integer) entry.getKey()) {
                appendForTrailingNumber(input, (Integer) entry.getKey());
                break;
            }
        }

        return sb.toString();
    }

    public String romanRepresentationOf(int input) {
        return mainNumberMapping.get(input);
    }

    public boolean isMainNumber(int input) {
        return mainNumberMapping.containsKey(input);
    }

    public void appendForTrailingNumber(int input, int integerNumber) {
        if (input > 500) {
            append(input, integerNumber, 100);
        } else if (input > 50) {
            append(input, integerNumber, 10);
        } else if (input > 1) {
            append(input, integerNumber, 1);
        }
    }

    public void append(int input, int integerNumber, int divisor) {
        if (input > integerNumber) {
            sb.append(romanRepresentationOf(integerNumber));
            for (int i = 0; i < (input - integerNumber) / divisor; i++) {
                sb.append(romanRepresentationOf(divisor));
            }
        }
    }

}
