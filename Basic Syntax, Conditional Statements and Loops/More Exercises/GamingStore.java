import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double balance = Double.parseDouble(scan.nextLine());
        String input = "";
        double total = 0;
        String game = "";

        while (true) {
            input = scan.nextLine();
            double price = 0;

            if ("Game Time".equals(input)) {
                break;
            }

            if ("OutFall 4".equals(input)) {
                price = 39.99;
            } else if ("CS: OG".equals(input)) {
                price = 15.99;
            } else if ("Zplinter Zell".equals(input)) {
                price = 19.99;
            } else if ("Honored 2".equals(input)) {
                price = 59.99;
            } else if ("RoverWatch".equals(input)) {
                price = 29.99;
            } else if ("RoverWatch Origins Edition".equals(input)) {
                price = 39.99;
            } else {
                System.out.println("Not Found");
                continue;
            }

            game = input;

            if (price > balance) {
                System.out.println("Too Expensive");
                continue;
            }

            total = total + price;
            System.out.printf("Bought %s%n", game);
            balance = balance - price;

            if (balance == 0) {
                System.out.println("Out of money!");
                return;
            }
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", total, balance);
    }
}
