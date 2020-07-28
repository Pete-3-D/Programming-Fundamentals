import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] articleParts = input.split(", ");


        int n = Integer.parseInt(scan.nextLine());

        Article article = new Article(articleParts[0], articleParts[1], articleParts[2]);

        for (int i = 0; i < n; i++) {
            input = scan.nextLine();
            String[] tokens = input.split(": ");
            String command = tokens[0];

            switch (command) {
                case "Edit": article.edit(tokens[1]); break;
                case "ChangeAuthor": article.changeAuthor(tokens[1]); break;
                case "Rename": article.rename(tokens[1]); break;
            }
        }

        System.out.println(article.toString());
    }
}
