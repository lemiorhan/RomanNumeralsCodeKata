import java.util.ArrayList;
import java.util.List;

public class DecimalDigitsSplitter {

    public List<Integer> split(int input) {
        List<Integer> list = new ArrayList<>();
        list.add(input - (input % 1000));
        input = input % 1000;

        list.add(input - (input % 100));
        input = input % 100;

        list.add(input - (input % 10));
        input = input % 10;

        list.add(input - (input % 1));
        return list;
    }
}
