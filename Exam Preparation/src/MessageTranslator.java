import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            String regex = "!(?<command>[A-Z][a-z]+)!:\\[(?<toEncrypt>[A-Za-z]{8,})\\]";
            Pattern messageValidator = Pattern.compile(regex);
            Matcher matcher = messageValidator.matcher(input);

            if (!matcher.find()) {
                System.out.println("The message is invalid");
            } else {
                String command = matcher.group("command");
                String toEncrypt = matcher.group("toEncrypt");

                System.out.printf("%s:", command);

                for (int j = 0; j < toEncrypt.length(); j++) {
                    int toPrint = toEncrypt.charAt(j);
                    System.out.print(" " + toPrint);
                }

                System.out.println();
            }
        }
    }
}
