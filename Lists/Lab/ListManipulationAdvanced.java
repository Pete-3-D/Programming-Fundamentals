import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while(!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    int temp = Integer.parseInt(tokens[1]);
                    if (numbers.contains(Integer.valueOf(temp)))
                        System.out.println("Yes");
                    else
                        System.out.println("No such number");
                    break;
                case "Print":
                    String command2 = tokens[1];
                    if ("even".equals(command2))
                        printEvenList(numbers);
                    else
                        printOddList(numbers);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int numberCondition = Integer.parseInt(tokens[2]);
                    printFiltered(numbers, condition, numberCondition);
                    break;
            }

            input = scan.nextLine();
        }
    }

    private static void printFiltered(List<Integer> numbers, String condition, int numberCondition) {
        switch (condition) {
            case ">":
                for (Integer number : numbers) {
                    if (number > numberCondition)
                        System.out.print(number + " ");
                }
                break;
            case "<":
                for (Integer number : numbers) {
                    if (number < numberCondition)
                        System.out.print(number + " ");
                }
                break;
            case ">=":
                for (Integer number : numbers) {
                    if (number >= numberCondition)
                        System.out.print(number + " ");
                }
                break;
            case "<=":
                for (Integer number : numbers) {
                    if (number <= numberCondition)
                        System.out.print(number + " ");
                }
                break;
        }
        System.out.println();
    }

    private static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = sum + number;
        }
        System.out.println(sum);
    }

    private static void printOddList(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 != 0)
                System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void printEvenList(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0)
                System.out.print(number + " ");
        }
        System.out.println();
    }
}
