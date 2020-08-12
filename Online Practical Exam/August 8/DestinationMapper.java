import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<sign>=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";

        String input = scan.nextLine();
        List<String> destinations = new LinkedList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinations));

        int travelPoints = 0;

        for (String s : destinations) {
            travelPoints = travelPoints + s.length();
        }

        System.out.printf("Travel Points: %d", travelPoints);
    }
}
