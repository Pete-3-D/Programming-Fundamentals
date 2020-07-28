import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int number = Integer.parseInt(input);
        String result = "";

        if (number % 10 == 0) {
            result = String.format("The number is divisible by 10");
        } else if (number % 7 == 0) {
            result = String.format("The number is divisible by 7");
        } else if (number % 6 == 0) {
            result = String.format("The number is divisible by 6");
        } else if (number % 3 == 0) {
            result = String.format("The number is divisible by 3");
        } else if (number % 2 == 0) {
            result = String.format("The number is divisible by 2");
        } else {
            result = String.format("Not divisible");
        }

        System.out.println(result);
    }
}
