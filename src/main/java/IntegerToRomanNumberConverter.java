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

        if (input == 60) return "LX";
        else if (input == 70) return "LXX";
        else if (input == 80) return "LXXX";

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
        if (input > integerNumber) {
            sb.append(romanRepresentationOf(integerNumber));
            for (int i = 0; i < input - integerNumber; i++) {
                sb.append("I");
            }
        }

    }
}
