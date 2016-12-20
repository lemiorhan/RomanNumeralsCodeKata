
public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
