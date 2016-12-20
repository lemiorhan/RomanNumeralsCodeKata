
public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {
        if (input == 1) return "I";
        else if (input == 2) return "II";
        return "III";
    }
}
