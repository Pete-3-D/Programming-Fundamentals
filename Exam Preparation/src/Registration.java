import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}\\d+)P@\\$";
        int n = Integer.parseInt(scan.nextLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern validUsername = Pattern.compile(regex);
            Matcher matcher = validUsername.matcher(input);

            if (matcher.find()) {
                System.out.println("Registration was successful");
                count++;
                String username = matcher.group("username");
                String password = matcher.group("password");
                System.out.printf("Username: %s, Password: %s%n", username, password);
            } else {
                System.out.println("Invalid username or password");
            }
        }

        System.out.printf("Successful registrations: %d", count);
    }
}
