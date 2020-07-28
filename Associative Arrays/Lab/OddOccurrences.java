import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String s : input) {
            String word = s.toLowerCase();
            if (counts.containsKey(word))
                counts.put(word, counts.get(word) + 1);
            counts.putIfAbsent(word, 1);
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (count == 0)
                    System.out.printf("%s", entry.getKey());
                else
                    System.out.printf(", %s", entry.getKey());
                count++;
            }
        }
    }
}
