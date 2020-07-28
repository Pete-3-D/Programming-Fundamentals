import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String message = "";

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            message = message + input;
        }

        int countBrackets = 0;

        for (char ch: message.toCharArray()) {
            if (ch == '(') {
                countBrackets++;
            } else if (ch == ')') {
                countBrackets--;
            }

            if (countBrackets == 2 || countBrackets < 0) {
                break;
            }
        }

        if (countBrackets != 0) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}
