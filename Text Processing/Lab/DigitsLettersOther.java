import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        String digits = "";
        String letters = "";
        String other = "";

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                digits = digits + word.charAt(i);
            } else if (Character.isLetter(word.charAt(i))) {
                letters = letters + word.charAt(i);
            } else {
                other = other + word.charAt(i);
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}
