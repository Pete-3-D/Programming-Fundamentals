import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countStrings = Integer.parseInt(scan.nextLine());
        String[] messages = new String[countStrings];

        for (int i = 0; i < countStrings; i++) {
            messages[i] = scan.nextLine();
        }

        int[] encrypted = new int[countStrings];

        for (int i = 0; i < countStrings; i++) { // sum
            int sum = 0;

            for (int j = 0; j < messages[i].length(); j++) {
                if (isVowel(messages[i].charAt(j))) {
                    sum = sum + (messages[i].charAt(j) * messages[i].length());
                } else {
                    sum = sum + (messages[i].charAt(j) / messages[i].length());
                }
            }

            encrypted[i] = sum; // save
        }

        Arrays.sort(encrypted);

        for (int i = 0; i < countStrings; i++) { // print
            System.out.println(encrypted[i]);
        }
    }

    public static boolean isVowel (char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': return true;
            default: return false;
        }
    }
}
