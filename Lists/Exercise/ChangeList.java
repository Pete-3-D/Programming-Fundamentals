import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");

            int element = Integer.parseInt(tokens[1]);

            if ("Delete".equals(tokens[0])) {
                deleteElements(numbers, element);
            } else {
                int position = Integer.parseInt(tokens[2]);
                if (position < numbers.size() && position >= 0)
                    numbers.add(position, element);
            }

            input = scan.nextLine();
        }

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void deleteElements(List<Integer> numbers, int element) {
        for (int i = 0; i < numbers.size(); i++) {
            int currentElement = numbers.get(i);

            if (currentElement == element) {
                numbers.remove(i);
                i--;
            }
        }
    }
}
