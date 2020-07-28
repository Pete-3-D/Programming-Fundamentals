import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!"END".equals(input)) {
            boolean print = isPalindrome(input);
            System.out.println(print);

            input = scan.nextLine();
        }
    }

    private static boolean isPalindrome(String input) {
        char[] reverseDigits = new char[input.length()];
        int index = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            reverseDigits[index] = input.charAt(i);
            index++;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != reverseDigits[i]) {
                return  false;
            }
        }

        return true;
    }
}
