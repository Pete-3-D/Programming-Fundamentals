import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());

        switch (product) {
            case "coffee":
                calculatePrice(quantity, 1.50);
                break;
            case "water":
                calculatePrice(quantity, 1.00);
                break;
            case "coke":
                calculatePrice(quantity, 1.40);
                break;
            case "snacks":
                calculatePrice(quantity, 2.00);
                break;
        }
    }

    private static void calculatePrice(int quantity, double price) {
        System.out.printf("%.2f", quantity * price);
    }
}
