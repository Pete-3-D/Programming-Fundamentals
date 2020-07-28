import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scan.nextLine().split("\\s+");

        int specialNumber = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);

        while (numbers.contains(specialNumber)) {
            int index = numbers.indexOf(specialNumber);

            int leftBound = Math.max(index - power, 0);
            int rightBound = Math.min(index + power, numbers.size() - 1);

            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
            //printList(numbers);
        }

        printSum(numbers);

    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers)
            System.out.print(number + " ");
    }

    private static void printSum(List<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum = sum + number;
        }

        System.out.println(sum);
    }
}
