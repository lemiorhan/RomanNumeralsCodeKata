import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanNumberConverter {


    public String convert(int input) {
        Map<Integer, String> mapping = new HashMap<Integer, String>() {{
            put(5, "V");
            put(10, "X");
            put(50, "L");
        }};
        if (mapping.containsKey(input))
            return mapping.get(input);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
