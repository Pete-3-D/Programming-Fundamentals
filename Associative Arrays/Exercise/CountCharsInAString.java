import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        Map<Character, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            charOccurences(occurrences, words[i]);
        }

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static void charOccurences(Map<Character, Integer> occurrences, String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (!occurrences.containsKey(currentChar)) {
                occurrences.put(currentChar, 1);
            } else {
                occurrences.put(currentChar, occurrences.get(currentChar) + 1);
            }
        }
    }
}
