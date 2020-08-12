import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        String input = scan.nextLine();

        while (!"Reveal".equals(input)) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace": {
                    int index = Integer.parseInt(tokens[1]);
                    message = insertSpace(message, index);
                    System.out.println(message);
                    break;
                }
                case "Reverse": {
                    String givenSubstring = tokens[1];
                    if (message.contains(givenSubstring)) {
                        message = reverse(message, givenSubstring);
                        System.out.println(message);
                    } else
                        System.out.println("error");
                    break;
                }
                case "ChangeAll": {
                    String givenSubstring = tokens[1];
                    String replacement = tokens[2];
                    message = message.replaceAll(givenSubstring, replacement);
                    System.out.println(message);
                    break;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);
    }

    private static String reverse(String message, String givenSubstring) {
        StringBuilder sb = new StringBuilder();

        int startIndex = message.indexOf(givenSubstring);
        int endIndex = startIndex + givenSubstring.length() - 1;

        for (int i = 0; i < startIndex; i++) {
            sb.append(message.charAt(i));
        }

        StringBuilder substring = new StringBuilder();

        for (int i = endIndex; i >= startIndex; i--) {
            substring.append(message.charAt(i));
        }

        for (int i = endIndex + 1; i < message.length(); i++) {
            sb.append(message.charAt(i));
        }

        sb.append(substring.toString());

        return sb.toString();
    }

    private static String insertSpace(String message, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (i == index)
                sb.append(" ");

            sb.append(message.charAt(i));
        }

        return sb.toString();

    }
}
