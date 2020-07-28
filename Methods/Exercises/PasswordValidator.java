import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        validatePassword(password);
    }

    private static void validatePassword(String password) {
        boolean validLength = validateLength(password);
        boolean validContents = validateContents(password);
        boolean twoDigits = countDigits(password);

        if (validContents && validLength && twoDigits)
            System.out.println("Password is valid");
    }

    private static boolean countDigits(String password) {
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                count++;
            }
        }

        if (count < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else
            return true;
    }

    private static boolean validateContents(String password) {
        for (int i = 0; i < password.length(); i++) {
            boolean isLetter = false;
            if (Character.isLetter(password.charAt(i)))
                isLetter = true;

            boolean isDigit = false;
            if (Character.isDigit(password.charAt(i)))
                isDigit = true;

            if (!(isDigit || isLetter)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }

        return true;
    }

    private static boolean validateLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }
}
