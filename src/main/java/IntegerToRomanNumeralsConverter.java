import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new HashMap() {{
            put(5, "V");
            put(10, "X");
        }};

        if (mapping.containsKey(input)) {
            return mapping.get(input);
        }


        for (Map.Entry entry : mapping.entrySet()) {
            if ((int) entry.getKey() == input + 1) {
                return "I" + entry.getValue();
            }
        }

        if (input > 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("V");
            for (int i = 0; i < input - 5; i++) {
                sb.append("I");
            }
            return sb.toString();
        } 

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
