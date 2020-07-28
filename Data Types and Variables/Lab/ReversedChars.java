import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sum = "";

        for (int i = 0; i < 3; i++) {
            char next = scan.nextLine().charAt(0);
            sum = sum + next;
        }

        for (int i = sum.length() - 1; i >= 0; i--) {
            System.out.printf("%c ", sum.charAt(i));
        }
    }
}
