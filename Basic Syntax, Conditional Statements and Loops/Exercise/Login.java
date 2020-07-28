import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String username = input;
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password = password + username.charAt(i);
        }

        for (int i = 0; i < 4; i++) {
            input = scan.nextLine();
            if (password.equals(input)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
                if (i == 2) {
                    System.out.printf("User %s blocked!", username);
                    break;
                }
            }
        }

    }
}
