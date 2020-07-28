import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] first = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[] second = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        boolean identical = true;
        int sum = 0;
        int index = 0;

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                identical = false;
                index = i;
                break;
            } else
                sum = sum + first[i];
        }

        if (identical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }
}
