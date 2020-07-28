import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());

        if ("add".equals(command)) {
            calculationAdd(firstNumber, secondNumber);
        } else if ("subtract".equals(command)) {
            calculationSubtract(firstNumber, secondNumber);
        } else if ("multiply".equals(command)) {
            calculationMultiply(firstNumber, secondNumber);
        } else if ("divide".equals(command)) {
            calculationDivide(firstNumber, secondNumber);
        }
    }

    private static void calculationAdd(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    private static void calculationSubtract(int firstNumber, int secondNumber) {
        System.out.println(firstNumber - secondNumber);
    }

    private static void calculationMultiply(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    private static void calculationDivide(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }
}
