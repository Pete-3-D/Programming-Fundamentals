import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputNumbers = input.split("\\s+");
        int[] numbers = new int[inputNumbers.length];

        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "swap": {
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);

                    int temp = numbers[index1];
                    numbers[index1] = numbers[index2];
                    numbers[index2] = temp;
                    break;
                }
                case "multiply": {
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);

                    int temp = numbers[index1] * numbers[index2];
                    numbers[index1] = temp;
                    break;
                }
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] - 1;
                    }

                    break;
            }

            input = scan.nextLine();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0)
                System.out.print(numbers[i]);
            else
                System.out.printf(", %d", numbers[i]);
        }

    }
}
