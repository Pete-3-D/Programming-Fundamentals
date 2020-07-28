import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = ">>(?<furnitureName>\\w+)<<(?<price>\\d+\\.*\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> furniture = new LinkedList<>();
        double total = 0.0;

        String input = scan.nextLine();

        while (!"Purchase".equals(input)) {
            Matcher furnitureStore = pattern.matcher(input);

            if (furnitureStore.find()) {
                furniture.add(furnitureStore.group("furnitureName"));
                double price = Double.parseDouble(furnitureStore.group("price"));
                price = price * Integer.parseInt(furnitureStore.group("quantity"));
                total = total + price;
            }

            input = scan.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", total);

    }
}
