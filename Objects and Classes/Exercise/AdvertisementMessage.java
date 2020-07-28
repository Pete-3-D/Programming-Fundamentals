import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String[] phrases =
                {"Excellent product.", "Such a great product.", "I always use that product."
                        , "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events =
                {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                        "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors =
                {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities =
                {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            int phrasePos = rnd.nextInt(phrases.length);
            int eventsPos = rnd.nextInt(events.length);
            int authorsPos = rnd.nextInt(authors.length);
            int citiesPos = rnd.nextInt(cities.length);

            String message = String.format("%s %s %s – %s",
                                phrases[phrasePos], events[eventsPos], authors[authorsPos], cities[citiesPos]);

            System.out.println(message);
        }

    }
}
