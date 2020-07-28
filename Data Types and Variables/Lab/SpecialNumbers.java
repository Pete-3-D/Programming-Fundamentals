import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int currentNum = i;

            while (currentNum != 0) {
                sum = sum + (currentNum % 10);
                currentNum = currentNum / 10;
            }

            boolean special = (sum == 5) || (sum == 7) || (sum == 11);

            if (special) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
