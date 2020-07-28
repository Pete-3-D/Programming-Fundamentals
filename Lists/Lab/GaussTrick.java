import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> numbers =
                Arrays.stream(scan.nextLine().split(" "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                break;
            }

            double current = numbers.get(i);
            double last = numbers.get(numbers.size() - 1);

            numbers.set(i, current + last);
            numbers.remove(numbers.size() - 1);
        }

        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);

    }

    private static String joinElementsByDelimiter(List<Double> items, String delimiter) {
        String result = "";

        for (Double item : items) {
            result = result + (new DecimalFormat("0.#").format(item) + delimiter);
        }

        return result;
    }
}
