import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        String[] words = scan.nextLine().split("\\s+");
        int min = Math.min(words[0].length(), words[1].length());

        for (int i = 0; i < min; i++) {
            int firstWordCode = words[0].charAt(i);
            int secondWordCode = words[1].charAt(i);

            sum = sum + (firstWordCode * secondWordCode);
        }

        sum = sum + remainingCharacters(words[0].length() > words[1].length() ? words[0] : words[1], min);
        System.out.println(sum);
    }

    private static int remainingCharacters(String word, int min) {
        int result = 0;

        for (int i = min; i < word.length(); i++) {
            result = result + word.charAt(i);
        }

        return  result;
    }
}
