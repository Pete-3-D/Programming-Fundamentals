import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<day>\\d{2})(?<delimiter>\\/|-|\\.)(?<month>[A-Z][a-z]{2})\\k<delimiter>(?<year>\\d{4})";

        String input = scan.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher dates = pattern.matcher(input);

        while (dates.find()) {
            String day = dates.group("day");
            String month = dates.group("month");
            String year = dates.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }

    }
}
