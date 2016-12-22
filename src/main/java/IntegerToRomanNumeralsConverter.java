import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new LinkedHashMap<Integer, String>() {{
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }};

        Map<Integer, Integer> chipper = new LinkedHashMap<Integer, Integer>() {{
            put(500, 100);
            put(50, 10);
            put(5, 1);
        }};


        if (mapping.containsKey(input)) {
            return mapping.get(input);
        }

        if (input == 400) {
            return "CD";
        } else if (input >= 40) {
            for (Map.Entry entry : mapping.entrySet()) {
                if ((int) entry.getKey() == input + 10) {
                    return "X" + entry.getValue();
                }
            }
        } else {
            for (Map.Entry entry : mapping.entrySet()) {
                if ((int) entry.getKey() == input + 1) {
                    return "I" + entry.getValue();
                }
            }
        }


        for (Map.Entry entry : mapping.entrySet()) {
            if (input > (int) entry.getKey()) {
                if (input > 500) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), chipper.get(500), mapping.get(chipper.get(500)));
                } else if (input > 50) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), chipper.get(50), mapping.get(chipper.get(50)));
                } else if (input > 5){
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), chipper.get(5), mapping.get(chipper.get(5)));
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }

    public String appendSuffix(int input, String romanNumber, int integerNumber, int chipper, String appenderRomanNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(romanNumber);
        for (int i = 0; i < (input - integerNumber) / chipper; i++) {
            sb.append(appenderRomanNumber);
        }
        return sb.toString();
    }

}
