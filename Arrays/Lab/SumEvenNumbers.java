import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.
                stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;

        for (int i : numbers) {
            if (i % 2 == 0)
                sum = sum + i;
        }

        System.out.println(sum);
    }
}
