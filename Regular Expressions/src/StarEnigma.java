import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // decrypt messages
        int n = Integer.parseInt(scan.nextLine());

        List<String> messages = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            String regex = "[starSTAR]";
            Pattern pattern = Pattern.compile(regex);
            Matcher messageDecryptor = pattern.matcher(input);

            int count = 0;

            while (messageDecryptor.find()) {
                count++;
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                int currentChar = input.charAt(j) - count;
                sb.append((char) currentChar);
            }

            messages.add(sb.toString());
        }

        //messages.forEach(System.out::println);

        // solve problem
        String decryptedRegex = "@(?<planetName>[a-zA-Z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)";
        List<String> attackedPlanets = new LinkedList<>();
        List<String> destroyedPlanets = new LinkedList<>();

        for (String s : messages) {
            Pattern pattern = Pattern.compile(decryptedRegex);
            Matcher message = pattern.matcher(s);

            while (message.find()) {
                String planetName = message.group("planetName");
                //int population = Integer.parseInt(message.group("population"));
                String attackType = message.group("attackType");
                //int soldierCount = Integer.parseInt(message.group("soldierCount"));

                if ("A".equals(attackType)) {
                    attackedPlanets.add(planetName);
                } else if ("D".equals(attackType)) {
                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.stream().sorted(String::compareTo).forEach(p -> System.out.println("-> " + p));
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.stream().sorted(String::compareTo).forEach(p -> System.out.println("-> " + p));
    }
}
