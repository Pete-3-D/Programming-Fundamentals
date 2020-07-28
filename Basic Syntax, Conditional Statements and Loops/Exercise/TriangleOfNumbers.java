import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(input);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
