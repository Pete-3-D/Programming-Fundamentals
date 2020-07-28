import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        double total = 0;
        String product = "";
        double price = 0;

        while (true) {
            input = scan.nextLine();

            if ("Start".equals(input)) {
                break;
            }

            double number = Double.parseDouble(input);

            if (number == 2
                    || number == 1
                    || number == 0.5
                    || number == 0.2
                    || number == 0.1) {
                total = total + number;
            } else {
                System.out.printf("Cannot accept %.2f%n", number);
            }
        }

        while (true) {
            input = scan.nextLine();

            if ("End".equals(input)) {
                System.out.printf("Change: %.2f", Math.abs(total));
                break;
            }

            product = input;

            if ("Nuts".equals(product)) {
                price = 2;
            } else if ("Water".equals(product)) {
                price = 0.7;
            } else if ("Crisps".equals(product)) {
                price = 1.5;
            } else if ("Soda".equals(product)) {
                price = 0.8;
            } else if ("Coke".equals(product)) {
                price = 1;
            } else {
                System.out.println("Invalid product");
                continue;
            }

            if (price <= total) {
                total = total - price;
                System.out.printf("Purchased %s%n", product);
            } else {
                System.out.printf("Sorry, not enough money%n");
            }
        }
    }
}
