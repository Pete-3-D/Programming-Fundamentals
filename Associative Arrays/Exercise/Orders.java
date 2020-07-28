import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, Integer> productQuantities = new LinkedHashMap<>();
        Map<String, Double> productPrices = new LinkedHashMap<>();

        while (!"buy".equals(input)) {
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (productQuantities.containsKey(product)) {
                int newQuantity = productQuantities.get(product) + quantity;
                productQuantities.put(product, newQuantity);
            } else {
                productQuantities.put(product, quantity);
            }

            productPrices.put(product, price);

            input = scan.nextLine();
        }

        for (Map.Entry<String, Integer> entry : productQuantities.entrySet()) {
            double totalPrice = entry.getValue() * productPrices.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }
    }
}
