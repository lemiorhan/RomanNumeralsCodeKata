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
                appendOnes(input, (Integer) entry.getKey());
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

    public void appendOnes(int input, int integerNumber) {
        if (input > 500) {
            if (input > integerNumber) {
                sb.append(romanRepresentationOf(integerNumber));
                for (int i = 0; i < (input - integerNumber) / 100; i++) {
                    sb.append("C");
                }
            }
        } else if (input > 50) {
            if (input > integerNumber) {
                sb.append(romanRepresentationOf(integerNumber));
                for (int i = 0; i < (input - integerNumber) / 10; i++) {
                    sb.append("X");
                }
            }
        } else {
            if (input > integerNumber) {
                sb.append(romanRepresentationOf(integerNumber));
                for (int i = 0; i < (input - integerNumber) / 1; i++) {
                    sb.append("I");
                }
            }
        }
    }
}
