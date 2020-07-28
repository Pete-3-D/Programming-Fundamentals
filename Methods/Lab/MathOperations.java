import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int b = Integer.parseInt(scan.nextLine());

        double result = calculate(a, operator, b);

        System.out.println(new DecimalFormat("0.##").format(result));
    }

    private static double calculate(int a, String operator, int b) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }

        return result;
    }
}
