import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {

    private Map<Integer, String> mapping;

    public String convert(int input) {

        mapping = new LinkedHashMap<Integer, String>() {{
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
                return romainRepresentationOf(input);
            } else if (input == mainNumber - chipperNumber) {
                return romainRepresentationOf(chipperNumber) + romainRepresentationOf(mainNumber);
            } else if (input >= mainNumber) {
                return appendSuffix(input, romainRepresentationOf(mainNumber), mainNumber, chipperNumber, romainRepresentationOf(chipperNumber));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }

    public String romainRepresentationOf(int mainNumber) {
        return mapping.get(mainNumber);
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
