import java.text.DecimalFormat;
import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        divideFactorials(a, b);
    }

    private static void divideFactorials(int a, int b) {
        double firstFactorial = calcFactorial(a);
        double secondFactorial = calcFactorial(b);

        double result = (firstFactorial / secondFactorial) * 1.0;

        System.out.printf("%.2f", result);
    }

    private static double calcFactorial(int a) {
        if (a == 0)
            return 1;
        else
            return a * calcFactorial(a - 1);
    }
}
