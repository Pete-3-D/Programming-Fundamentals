import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int number = 0;
        int factorial = 1;
        int sumFactorial = 0;

        for (int i = 0; i < input.length(); i++) {
            number = Integer.parseInt("" + input.charAt(i));
            for (int j = 1; j <= number; j++) {
                factorial = factorial * j;
            }
            sumFactorial = sumFactorial + factorial;
            factorial = 1;
        }

        number = Integer.parseInt(input);

        if (sumFactorial == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
