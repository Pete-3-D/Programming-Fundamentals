import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);

        if (first < second)
            charsInRange(first, second);
        else
            charsInRange(second, first);
    }

    private static void charsInRange(char first, char second) {
        for (int i = first + 1; i < second; i++) {
            char print = (char) i;
            System.out.printf("%c ", print);
        }
    }
}
