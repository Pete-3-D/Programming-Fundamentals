import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "\\+359(?<delimiter> |-)2\\k<delimiter>\\d{3}\\k<delimiter>\\d{4}\\b";
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> matchedPhones = new LinkedList<>();

        while (matcher.find()) {
            matchedPhones.add(matcher.group());
        }

        System.out.println(String.join(", ", matchedPhones));
    }
}
