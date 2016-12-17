
public class TrainingIntegerToRomanNumberConverter {
    IntegerToRomanNumberMapping mapping;

    public TrainingIntegerToRomanNumberConverter(IntegerToRomanNumberMapping mapping) {
        this.mapping = mapping;
    }

    public String convert(int input) {
        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input == mainInteger - mapping.divisorOf(mainInteger)) {
                return appendForTrailingNumber(input);
            }
        }
        return null;
    }

    public String appendForTrailingNumber(int input) {
        StringBuilder fsb = new StringBuilder();
        for (Integer mainInteger : mapping.mainIntegers()) {
            if (input == mainInteger - mapping.divisorOf(mainInteger)) {
                fsb.append(mapping.romanRepresentationOf(mapping.divisorOf(mainInteger))).append(mapping.romanRepresentationOf(mainInteger));
                break;
            }
        }
        return fsb.toString();
    }
}
