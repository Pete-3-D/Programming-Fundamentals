import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sorted = Arrays.stream(scan.nextLine().split("\\s+"))
                                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                                .collect(Collectors.toList());

        int limit = Integer.min(3, sorted.size());

        for (int i = 0; i < limit; i++) {
            System.out.printf("%d ", sorted.get(i));
        }
    }
}
