import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new LinkedHashMap<Integer, String>() {{
            put(50, "L");
            put(10, "X");
            put(5, "V");
        }};

        if (mapping.containsKey(input)) {
            return mapping.get(input);
        }

        if (input == 40) {
            return "XL";
        } else {
            for (Map.Entry entry : mapping.entrySet()) {
                if ((int) entry.getKey() == input + 1) {
                    return "I" + entry.getValue();
                }
            }
        }

        if (input == 60) {
            return "LX";
        } else {
            for (Map.Entry entry : mapping.entrySet()) {
                if (input > (int) entry.getKey()) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey());
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }

    public String appendSuffix(int input, String romanNumber, int integerNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(romanNumber);
        for (int i = 0; i < input - integerNumber; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
