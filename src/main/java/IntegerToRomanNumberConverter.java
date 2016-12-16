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

        for (Map.Entry entry : mainNumberMapping.entrySet()) {
            if (input > (Integer) entry.getKey()) {
                appendOnes(input, (Integer) entry.getKey());
                break;
            }
        }

        return sb.toString();
    }

    public void appendOnes(int input, int integerNumber) {
        if (input > integerNumber) {
            sb.append(mainNumberMapping.get(integerNumber));
            for (int i = 0; i < input - integerNumber; i++) {
                sb.append("I");
            }
        }

    }
}
