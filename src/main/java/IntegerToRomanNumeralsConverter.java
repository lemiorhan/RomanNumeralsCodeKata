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
                return appendPrefix(mainNumber, chipperNumber);
            } else if (input >= mainNumber) {
                if (input == 2000 || input == 3000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(romainRepresentationOf(mainNumber));
                    for (int i = 0; i < (input - mainNumber) / mainNumber; i++) {
                        sb.append(romainRepresentationOf(mainNumber));
                    }
                    return sb.toString();
                } else if (input == 200 || input == 300) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(romainRepresentationOf(mainNumber));
                    for (int i = 0; i < (input - mainNumber) / mainNumber; i++) {
                        sb.append(romainRepresentationOf(mainNumber));
                    }
                    return sb.toString();
                } else if (input == 20 || input == 30) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(romainRepresentationOf(mainNumber));
                    for (int i = 0; i < (input - mainNumber) / mainNumber; i++) {
                        sb.append(romainRepresentationOf(mainNumber));
                    }
                    return sb.toString();
                }
                return appendSuffix(mainNumber, chipperNumber, input);
            }
        }

        throw new RuntimeException("Unable to convert the given integer to roman numerals");
    }

    public String appendPrefix(int mainNumber, int chipperNumber) {
        return romainRepresentationOf(chipperNumber) + romainRepresentationOf(mainNumber);
    }


    public String appendSuffix(int mainNumber, int chipperNumber, int input) {
        StringBuilder sb = new StringBuilder();
        sb.append(romainRepresentationOf(mainNumber));
        for (int i = 0; i < (input - mainNumber) / chipperNumber; i++) {
            sb.append(romainRepresentationOf(chipperNumber));
        }
        return sb.toString();
    }

    public String romainRepresentationOf(int mainNumber) {
        return mapping.get(mainNumber);
    }
}
