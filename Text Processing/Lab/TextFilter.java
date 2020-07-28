import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            String currentWord = bannedWords[i];
            String replacement = getReplacement(currentWord);
            text = text.replace(currentWord, replacement);
        }

        System.out.println(text);
    }

    private static String getReplacement(String currentWord) {
        List<String> replacement = new LinkedList<>();

        for (int i = 0; i < currentWord.length(); i++) {
            replacement.add("*");
        }

        return String.join("", replacement);
    }
}
