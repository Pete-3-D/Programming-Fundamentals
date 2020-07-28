import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        printTopNumbers(n);
    }

    private static void printTopNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (divisibleByEight(i) && holdsOddDigit(i))
                System.out.println(i);
        }
    }
    private static boolean divisibleByEight(int i) {
        int sum = 0;

        while (i != 0) {
            sum = sum + i % 10;
            i = i / 10;
        }

        return sum % 8 == 0;
    }

    private static boolean holdsOddDigit(int i) {
        while (i != 0) {
            if ((i % 10) % 2 != 0)
                return true;
            else
                i = i / 10;
        }

        return false;
    }
}
