import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "(#|@)(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";

        Pattern wordPairs = Pattern.compile(regex);
        Matcher matcher = wordPairs.matcher(input);

        int wordPairCount = 0;

        LinkedList<String> resultSet = new LinkedList<>();

        while (matcher.find()) {
            wordPairCount++;

            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");

            String reversedfirstWord = reverseString(firstWord);

            if (secondWord.equals(reversedfirstWord))
                resultSet.add(firstWord + " <=> " + secondWord);
        }

        if (wordPairCount != 0)
            System.out.printf("%d word pairs found!%n", wordPairCount);
        else
            System.out.println("No word pairs found!");

        if (!resultSet.isEmpty()) {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", resultSet));
        } else
            System.out.println("No mirror words!");
    }

    private static String reverseString(String firstWord) {
        StringBuilder sb = new StringBuilder();

        for (int i = firstWord.length() - 1; i >= 0; i--) {
            sb.append(firstWord.charAt(i));
        }

        return sb.toString();
    }
}
