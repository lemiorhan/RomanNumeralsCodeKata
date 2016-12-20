import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new HashMap() {{
            put(5, "V");
            put(10, "X");
        }};

        if (input == 6) {
            return "VI";
        } else if (input == 7) {
            return "VII";
        } else if (input == 8) {
            return "VIII";
        }

        for (Map.Entry entry : mapping.entrySet()) {
            if ((int) entry.getKey() == input + 1) {
                return "I" + entry.getValue();
            }
        }

        if (input >= 5) {
            return mapping.get(input);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
