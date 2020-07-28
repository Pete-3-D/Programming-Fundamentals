import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        int[] numbers = new int[text.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(text[i]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == n) {
                    System.out.printf("%d %d%n", numbers[i], numbers[j]);
                }
            }
        }

    }
}
