import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        subtract(sum(a, b), c);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void subtract(int a, int b) {
        System.out.println(a - b);
    }
}
