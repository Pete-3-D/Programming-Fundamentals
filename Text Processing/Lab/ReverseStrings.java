import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String reversed = "";

        while (!"end".equals(input)) {
            reversed = reverseString(input);
            System.out.printf("%s = %s%n", input, reversed);

            input = scan.nextLine();
        }
    }

    private static String reverseString(String input) {
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        return reversed;
    }
}
