import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumberConverter {

    Map<Integer, String> mainNumberMapping;
    private StringBuilder sb;
    private Map<Integer, Integer> divisorMap;

    public IntegerToRomanNumberConverter(Map<Integer, String> mainNumberMapping, Map<Integer, Integer> divisorMap) {
        this.mainNumberMapping = mainNumberMapping;
        this.divisorMap = divisorMap;
    }

    public String convert(int input) {
        sb = new StringBuilder();

        if (isMainNumber(input))
            return romanRepresentationOf(input);

        for (Map.Entry entry : divisorMap.entrySet()) {
            if (input == (int) entry.getKey() - (int) entry.getValue()) {
                appendForTrailingNumber(input);
                return sb.toString();
            }
        }

        for (Map.Entry entry : mainNumberMapping.entrySet()) {
            if (input > (Integer) entry.getKey()) {
                appendForFollowingNumber(input, (Integer) entry.getKey());
                break;
            }
        }

        return sb.toString();
    }

    public void appendForTrailingNumber(int input) {
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
