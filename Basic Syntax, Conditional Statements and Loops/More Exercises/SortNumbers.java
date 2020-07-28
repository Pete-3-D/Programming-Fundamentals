import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = new double [3];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(scan.nextLine());
        }

        boolean sorted = false;
        double temp;

        while(!sorted) {
            sorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] < numbers[i + 1]) {
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.printf("%.0f%n", numbers[i]);
        }
    }
}
