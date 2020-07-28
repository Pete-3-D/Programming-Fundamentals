import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        int number = 0;

        while (true) {
            input = scan.nextLine();
            number = Integer.parseInt(input);

            if (Math.abs(number) % 2 == 0) {
                break;
            } else {
                System.out.println("Please write an even number.");
            }
        }

        System.out.printf("The number is: %d", Math.abs(number));
    }
}
