import java.util.Map;

public class IntegerToRomanNumberConverter {

    Map<Integer, String> mainNumberMapping;
    private Map<Integer, Integer> divisorMap;
    private DecimalDigitsSplitter splitter;

    public IntegerToRomanNumberConverter(Map<Integer, String> mainNumberMapping, Map<Integer, Integer> divisorMap, DecimalDigitsSplitter splitter) {
        this.mainNumberMapping = mainNumberMapping;
        this.divisorMap = divisorMap;
        this.splitter = splitter;
    }

    public String convert(int input) {
        StringBuilder sb = new StringBuilder();
        for (Integer digit : splitter.split(input)) {
            if (digit != 0) sb.append(convertDigit(digit));
        }
        return sb.toString();
    }

    public String convertDigit(int input) {
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
        throw new RuntimeException("Unable to convert");
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
            fsb.append(romanRepresentationOf(integerNumber));
            for (int i = 0; i < (input - integerNumber) / divisor; i++) {
                fsb.append(romanRepresentationOf(divisor));
            }
        }
        return fsb.toString();
    }

}
