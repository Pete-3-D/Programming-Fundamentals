import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int fourth = Integer.parseInt(scan.nextLine());

        long result = first + second;
        result = result / third;
        result = result * fourth;

        System.out.println(result);
    }
}
