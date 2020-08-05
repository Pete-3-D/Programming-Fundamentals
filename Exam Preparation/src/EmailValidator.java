import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String input = scan.nextLine();

        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Make":
                    command = tokens[1];

                    if ("Upper".equals(command)) {
                        email = email.toUpperCase();
                    } else {
                        email = email.toLowerCase();
                    }

                    System.out.println(email);
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    getDomain(email, count);
                    break;
                case "GetUsername":
                    if (!email.contains("@")) {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    } else {
                        getUsername(email);
                    }

                    break;
                case "Replace":
                    char toReplace = tokens[1].charAt(0);
                    email = email.replace(toReplace, '-');
                    System.out.println(email);
                    break;
                case "Encrypt": 
                    encrypt(email);
                    break;
            }

            input = scan.nextLine();
        }
    }

    private static void encrypt(String email) {
        for (int i = 0; i < email.length(); i++) {
            int currentChar = email.charAt(i);
            System.out.print(currentChar + " ");
        }
        System.out.println();
    }

    private static void getUsername(String email) {
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@')
                break;

            System.out.print(email.charAt(i));
        }
        System.out.println();
    }

    private static void getDomain(String email, int count) {
        String toPrint = email.substring(email.length() - count, email.length());
        System.out.println(toPrint);
    }
}
