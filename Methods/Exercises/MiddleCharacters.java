import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        middleCharacter(text);
    }

    private static void middleCharacter(String text) {
        int middleIndex = -1;
        int evenIndex = -1;

        if (text.length() % 2 == 0) {
            middleIndex = text.length() / 2 - 1;
            evenIndex = middleIndex + 1;

            for (int i = 0; i < text.length(); i++) {
                if (i == middleIndex || i == evenIndex)
                    System.out.printf("%c", text.charAt(i));
            }
        } else {
            middleIndex = (text.length() / 2);

            for (int i = 0; i < text.length(); i++) {
                if (i == middleIndex)
                    System.out.printf("%c", text.charAt(i));
            }
        }
    }
}
