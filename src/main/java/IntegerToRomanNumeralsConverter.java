
public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        if (input == 5) {
            return "V";
        } else if (input == 10) {
            return "X";
        } else if (input == 50) {
            return "L";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
