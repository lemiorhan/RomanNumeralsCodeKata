import java.util.HashMap;
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
        Map<Integer, Integer> denominatorDecisionMap = new HashMap<Integer, Integer>() {{
            put(500, 100);
            put(50, 10);
            put(1, 1);
        }};

        if (input > 500) {
            if (input > integerNumber) {
                sb.append(romanRepresentationOf(integerNumber));
                for (int i = 0; i < (input - integerNumber) / 100; i++) {
                    sb.append(romanRepresentationOf(100));
                }
            }
        } else if (input > 50) {
            if (input > integerNumber) {
                sb.append(romanRepresentationOf(integerNumber));
                for (int i = 0; i < (input - integerNumber) / 10; i++) {
                    sb.append(romanRepresentationOf(10));
                }
            }
        } else if (input > 1) {
            if (input > integerNumber) {
                sb.append(romanRepresentationOf(integerNumber));
                for (int i = 0; i < (input - integerNumber) / 1; i++) {
                    sb.append(romanRepresentationOf(1));
                }
            }
        }
    }

}
