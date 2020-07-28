import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(input);
        int product = 0;

        for (int i = 1; i <= 10; i++) {
            product = n * i;
            System.out.printf("%d X %d = %d%n", n, i, product);
        }
    }
}
