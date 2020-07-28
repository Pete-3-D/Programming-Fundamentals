import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        printSign(num);
    }

    private static void printSign(int num) {
        String result = "";

        if (num > 0) {
            result = String.format("The number %d is positive.", num);
        } else if (num < 0) {
            result = String.format("The number %d is negative.", num);
        } else {
            result = String.format("The number %d is zero.", num);
        }

        System.out.println(result);
    }
}
