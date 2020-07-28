import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(input);
        int count = 0;
        int sum = 0;
        int oddNumber = 1;

        while (count < n) {
            System.out.println(oddNumber);
            sum += oddNumber;
            oddNumber += 2;
            count++;
        }

        System.out.printf("Sum: %d", sum);
    }
}
