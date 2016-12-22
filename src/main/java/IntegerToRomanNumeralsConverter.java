import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new LinkedHashMap<Integer, String>() {{
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }};

        Map<Integer, Integer> chipper = new LinkedHashMap<Integer, Integer>() {{
            put(1000, 100);
            put(500, 100);
            put(100, 10);
            put(50, 10);
            put(10, 1);
            put(5, 1);
            put(1, 1);
        }};
        
        for (Map.Entry entry : mapping.entrySet()) {
            int mainNumber = (int) entry.getKey();
            int chipperNumber = chipper.get(mainNumber);

            if (input == mainNumber) {
                return mapping.get(input);
            } else if (input == mainNumber - chipperNumber) {
                return mapping.get(chipperNumber) + mapping.get(mainNumber);
            }
        }

        for (Map.Entry entry : mapping.entrySet()) {
            if (input > (int) entry.getKey()) {
                if (input > 500) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), chipper.get(500), mapping.get(chipper.get(500)));
                } else if (input > 50) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), chipper.get(50), mapping.get(chipper.get(50)));
                } else if (input > 5) {
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
