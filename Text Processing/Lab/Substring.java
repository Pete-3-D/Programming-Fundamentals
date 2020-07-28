import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = scan.nextLine();
        String secondWord = scan.nextLine();

        while (secondWord.indexOf(firstWord) != -1) {
            int index = secondWord.indexOf(firstWord);
            secondWord = secondWord.replace(firstWord, "");
        }

        System.out.println(secondWord);
    }
}
