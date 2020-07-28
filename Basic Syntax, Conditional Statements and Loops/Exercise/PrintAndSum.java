import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int startNumber = Integer.parseInt(input);
        input = scan.nextLine();
        int endNumber = Integer.parseInt(input);
        int sum = 0;

        for (int i = startNumber; i <= endNumber; i++) {
            System.out.printf("%d ", i);
            sum = sum + i;
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}
