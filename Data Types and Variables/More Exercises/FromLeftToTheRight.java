import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] values = input.split("\\s+");
            long biggerNumber = Math.max(Long.parseLong(values[0]), Long.parseLong(values[1]));

            long sum = sumDigits(biggerNumber);
            System.out.println(sum);
        }
    }

    public static long sumDigits(Long number) {
        long sum = 0;

        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }

        return Math.abs(sum);
    }
}
