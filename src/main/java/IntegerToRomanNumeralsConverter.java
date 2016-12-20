import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new HashMap() {{
            put(5, "V");
            put(10,"X");
            put(50, "L");
        }};

        if (input == 4) {
            return "IV";
        } else if (input == 9) {
            return "IX";
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
