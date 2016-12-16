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

        if (mainNumberMapping.containsKey(input))
            return mainNumberMapping.get(input);

        if (input > 10) {
            appendOnes(input, "X", 10);
        } else if (input > 5) {
            appendOnes(input, "V", 5);
        } else {
            appendOnes(input, "I", 1);
        }
        return sb.toString();
    }

    public void appendOnes(int input, String romanNumber, int integerNumber) {
        if (input > 5) {
            sb.append(romanNumber);
            for (int i = 0; i < input - integerNumber; i++) {
                sb.append("I");
            }
        } else {
            for (int i = 0; i < input; i++) {
                sb.append("I");
            }

        }
    }
}
