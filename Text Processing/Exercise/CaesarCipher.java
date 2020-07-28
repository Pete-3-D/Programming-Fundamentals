import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            char encryptedSymbol = (char) (symbol + 3);

            encrypted.append(encryptedSymbol);
        }

        System.out.println(encrypted);
    }
}
