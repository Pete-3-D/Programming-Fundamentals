import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        double total = 0;

        for (String s : input) {
            char currentChar = s.charAt(0);

            int numericValue = Math.abs(96 - (int) (Character.toLowerCase(currentChar)));

            double number = getNum(s);
            double result = 0;

            if (Character.isUpperCase(currentChar)) {
                result = (number * 1.0) / numericValue;
            } else {
                result = number * numericValue;
            }

            currentChar = s.charAt(s.length() - 1);

            numericValue = Math.abs(96 - (int) (Character.toLowerCase(currentChar)));

            if (Character.isUpperCase(currentChar)) {
                result = result - numericValue;
            } else {
                result = result + numericValue;
            }

            total = total + result;
        }

        System.out.printf("%.2f", total);
    }

    private static double getNum(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                result.append(s.charAt(i));
        }

        return Double.parseDouble(result.toString());
    }
}
