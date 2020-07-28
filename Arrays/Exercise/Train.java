import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] passengers = new int[n];

        for (int i = 0; i < n; i++) {
            passengers[i] = Integer.parseInt(scan.nextLine());
        }

        int sum = 0;

        for (int i : passengers) {
            sum = sum + i;
            System.out.printf("%d ", i);
        }

        System.out.println();
        System.out.println(sum);
    }
}
