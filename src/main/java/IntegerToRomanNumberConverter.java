import java.util.LinkedHashMap;
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

        if (isTrailingNumber(input)) {
            appendForTrailingNumber(input);
            return sb.toString();
        }

        for (Map.Entry entry : mainNumberMapping.entrySet()) {
            if (input > (Integer) entry.getKey()) {
                appendForFollowingNumber(input, (Integer) entry.getKey());
                break;
            }
        }

        return sb.toString();
    }

    private boolean isTrailingNumber(int input) {
        return (input == 4 || input == 9 || input == 40 || input == 90 || input == 400 || input == 900);
    }

    public void appendForTrailingNumber(int input) {
        Map<Integer, Integer> divisorMap = new LinkedHashMap<Integer, Integer>() {{
            put(1000, 100);
            put(500, 100);
            put(100, 10);
            put(50, 10);
            put(10, 1);
            put(5, 1);
            put(1, 1);
        }};

        for (Map.Entry entry : divisorMap.entrySet()) {
            if (input == (int) entry.getKey() - (int) entry.getValue()) {
                sb.append(mainNumberMapping.get(entry.getValue())).append(mainNumberMapping.get(entry.getKey()));
                break;
            }
        }
    }

    public String romanRepresentationOf(int input) {
        return mainNumberMapping.get(input);
    }

    public boolean isMainNumber(int input) {
        return mainNumberMapping.containsKey(input);
    }

    public void appendForFollowingNumber(int input, int integerNumber) {
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
