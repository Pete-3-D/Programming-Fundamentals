import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        countVowels(text);
    }

    private static void countVowels(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);
            switch (letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': count++; break;
            }
        }

        System.out.println(count);
    }
}
