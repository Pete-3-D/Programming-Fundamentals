import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int[] numbers = Arrays.stream(input.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        input = scan.nextLine();
        List<Character> message = new ArrayList<>();
        StringToCharList(message, input);

        for (int i = 0; i < numbers.length; i++) {
            int sum = calculateSum(numbers[i]);

            if (sum >= message.size()) {
                sum = sum % message.size();
            }

            System.out.print(message.get(sum));
            message.remove(sum);
        }
    }

    private static int calculateSum(int number) {
        int sum = 0;

        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }

        return sum;
    }

    private static void StringToCharList(List<Character> message, String input) {
        for (int i = 0; i < input.length(); i++) {
            message.add(input.charAt(i));
        }
    }
}
