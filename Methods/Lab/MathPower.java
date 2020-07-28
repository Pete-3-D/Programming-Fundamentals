import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = Double.parseDouble(scan.nextLine());
        double pow = Double.parseDouble(scan.nextLine());

        double result = getPow(num, pow);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double getPow(double num, double pow) {
        return Math.pow(num, pow);
    }
}
