import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());
        double b = Double.parseDouble(scan.nextLine());

        double eps = 0.000001;
        double difference = Math.abs(a - b);

        if (difference <= eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
