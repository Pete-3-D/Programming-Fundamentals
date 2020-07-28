import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNumber = scan.nextLine();
        int multiplier = Integer.parseInt(scan.nextLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        while (bigNumber.charAt(0) == '0') {
            bigNumber = bigNumber.substring(1);
        }

        StringBuilder result = new StringBuilder();
        int remainder = 0;
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int number = digit * multiplier + remainder;

            if (number > 9) {
                remainder = number / 10;
                number = number % 10;
            } else {
                remainder = 0;
            }

            result.append(number);
        }

        if (remainder != 0) {
            result.append(remainder);
        }

        System.out.println(result.reverse().toString());

    }
}
