import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split(", "))
                                .collect(Collectors.toList());

        String letterRegex = "[A-Za-z]";
        String digitRegex = "\\d";

        Pattern letterPatern = Pattern.compile(letterRegex);
        Pattern digitPatern = Pattern.compile(digitRegex);

        Map<String, Integer> race = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (!"end of race".equals(input)) {
            StringBuilder sb = new StringBuilder();
            Matcher letterMatcher = letterPatern.matcher(input);

            while (letterMatcher.find()) {
                sb.append(letterMatcher.group());
            }

            if (names.contains(sb.toString())) {
                race.putIfAbsent(sb.toString(), 0);
                int km = race.get(sb.toString());

                Matcher digitMatcher = digitPatern.matcher(input);

                while (digitMatcher.find()) {
                    km = km + Integer.parseInt(digitMatcher.group());
                }

                race.put(sb.toString(), km);
            }

            input = scan.nextLine();
        }

        List<String> output = new LinkedList<>();
        output.add("1st place: ");
        output.add("2nd place: ");
        output.add("3rd place: ");

        race.entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue())).limit(3)
            .forEach(r -> System.out.println(output.remove(0) + r.getKey()));
    }
}
