import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sum = "";

        for (int i = 0; i < 3; i++) {
            char next = scan.nextLine().charAt(0);
            sum = sum + next;
        }

        System.out.println(sum);
    }
}
