import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double averageNumber = findAverage(numbers);

        List<Integer> topNumbers = new ArrayList<>();

        for (int n : numbers) {
            if (n > averageNumber) {
                topNumbers.add(n);
            }
        }

        if (topNumbers.isEmpty())
            System.out.println("No");
        else
            Collections.sort(topNumbers, Collections.reverseOrder());

        for (int i = 0; i < topNumbers.size(); i++) {
            System.out.printf("%d ", topNumbers.get(i));
            if (i == 4)
                break;
        }
    }

    private static double findAverage(List<Integer> numbers) {
        double average = 0;

        for (int n : numbers) {
            average = average + n;
        }

        average = average / numbers.size();
        return average;
    }
}
