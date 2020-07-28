import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String input = "";

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = scan.nextLine();
            String[] articleParts = input.split(", ");
            String title = articleParts[0];
            String content = articleParts[1];
            String author = articleParts[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }

        input = scan.nextLine();
        String criteria = input;

        if ("title".equals(criteria))
            articles.stream()
                .sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()))
                .forEach(a -> System.out.println(a.toString()));
        else if ("content".equals(criteria))
            articles.stream()
                    .sorted((a1, a2) -> a1.getContent().compareTo(a2.getContent()))
                    .forEach(a -> System.out.println(a.toString()));
        else if ("author".equals(criteria))
            articles.stream()
                    .sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                    .forEach(a -> System.out.println(a.toString()));
    }
}
