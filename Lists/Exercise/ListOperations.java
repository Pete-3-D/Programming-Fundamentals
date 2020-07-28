import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scan.nextLine();

        while(!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add": {
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                }
                case "Insert": {
                    int number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);

                    if (index < 0 || index > numbers.size()) {
                        System.out.println("Invalid index");
                        break;
                    } else {
                        numbers.add(index, number);
                    }

                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);

                    if (index < 0 || index > numbers.size()) {
                        System.out.println("Invalid index");
                        break;
                    } else {
                        numbers.remove(index);
                    }

                    break;
                }
                case "Shift":
                    int count = Integer.parseInt(tokens[2]);
                    if ("left".equals(tokens[1])) {
                        shiftLeft(numbers, count);
                    } else {
                        shiftRight(numbers, count);
                    }
                    break;

            }
            input = scan.nextLine();
        }

        printList(numbers);
    }

    private static void shiftRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int lastNumber = numbers.get(numbers.size() - 1);
            numbers.add(0, lastNumber);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            int firstNumber = numbers.get(0);
            numbers.add(firstNumber);
            numbers.remove(0);
        }
    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
