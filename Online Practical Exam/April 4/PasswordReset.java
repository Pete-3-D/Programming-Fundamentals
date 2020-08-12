import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        String input = scan.nextLine();

        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd": {
                    password = takeOdd(password);
                    System.out.println(password);
                    break;
                }
                case "Cut": {
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password = cutPassword(password, index, length);
                    System.out.println(password);
                    break;
                }
                case "Substitute": {
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (password.contains(String.valueOf(substring))) {
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    }
                    else
                        System.out.println("Nothing to replace!");

                    break;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("Your password is: %s", password);
    }

    private static String cutPassword(String password, int index, int length) {
        String firstPart = password.substring(0, index);
        String secondPart = password.substring(index + length);

        password = firstPart + secondPart;
        return password;
    }

    private static String takeOdd(String password) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                sb.append(password.charAt(i));
            }
        }

        return sb.toString();
    }
}
