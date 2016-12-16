import java.util.Map;

public class IntegerToRomanNumberConverter {

    Map<Integer, String> mainNumberMapping;
    private Map<Integer, Integer> divisorMap;

    public IntegerToRomanNumberConverter(Map<Integer, String> mainNumberMapping, Map<Integer, Integer> divisorMap) {
        this.mainNumberMapping = mainNumberMapping;
        this.divisorMap = divisorMap;
    }

    public String convert(int input) {
        if (isMainNumber(input))
            return romanRepresentationOf(input);

        for (Map.Entry entry : divisorMap.entrySet()) {
            if (input == (int) entry.getKey() - (int) entry.getValue()) {
                return appendForTrailingNumber(input);
            }
        }

        for (Map.Entry entry : mainNumberMapping.entrySet()) {
            if (input > (Integer) entry.getKey()) {
                return appendForFollowingNumber(input, (Integer) entry.getKey());
            }
        }
        return null;
    }

    public String appendForTrailingNumber(int input) {
        StringBuilder fsb = new StringBuilder();
        for (Map.Entry entry : divisorMap.entrySet()) {
            if (input == (int) entry.getKey() - (int) entry.getValue()) {
                fsb.append(mainNumberMapping.get(entry.getValue())).append(mainNumberMapping.get(entry.getKey()));
                break;
            }
        }
        return fsb.toString();
    }

    public String romanRepresentationOf(int input) {
        return mainNumberMapping.get(input);
    }

    public boolean isMainNumber(int input) {
        return mainNumberMapping.containsKey(input);
    }

    public String appendForFollowingNumber(int input, int integerNumber) {
        if (input > 500) {
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
            fsb.append(romanRepresentationOf(integerNumber));
            for (int i = 0; i < (input - integerNumber) / divisor; i++) {
                fsb.append(romanRepresentationOf(divisor));
            }
        }
        return fsb.toString();
    }

}
