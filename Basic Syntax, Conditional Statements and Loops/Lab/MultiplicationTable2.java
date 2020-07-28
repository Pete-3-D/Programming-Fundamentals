import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(input);
        input = scan.nextLine();
        int multiplier = Integer.parseInt(input);
        int product = 0;

        if (multiplier > 10) {
            product = n * multiplier;
            System.out.printf("%d X %d = %d%n", n, multiplier, product);
        } else {
            for (int i = multiplier; i <= 10; i++) {
            product = n * i;
            System.out.printf("%d X %d = %d%n", n, i, product);
            }
        }
    }
}
