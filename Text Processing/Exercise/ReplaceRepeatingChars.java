import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        char currentLetter = input.charAt(0);
        System.out.print(currentLetter);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != currentLetter) {
                currentLetter = input.charAt(i);
                System.out.print(currentLetter);
            }
        }
    }
}
