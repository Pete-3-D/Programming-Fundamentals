import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int result = multiplyEvenOdd(input);
        System.out.println(result);
    }

    private static int multiplyEvenOdd(String input) {
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                continue;
            }

            int currentDigit = Integer.parseInt("" + input.charAt(i));

            if (currentDigit % 2 == 0) {
                sumOdd = sumOdd + currentDigit;
            } else {
                sumEven = sumEven + currentDigit;
            }
        }

        return sumEven * sumOdd;
    }
}
