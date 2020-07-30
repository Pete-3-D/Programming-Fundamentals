import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        //String regex = "%(?<customerName>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d+)\\$";


        String nameRegex = "%(?<customerName>[A-Z][a-z]+)%";
        String productRegex = "<(?<product>\\w+)>";
        String countRegex = "\\|(?<count>\\d+)\\|";
        String priceRegex = "(?<price>\\d+\\.?\\d+)\\$";

        //Pattern pattern = Pattern.compile(regex);
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern productPattern = Pattern.compile(productRegex);
        Pattern countPattern = Pattern.compile(countRegex);
        Pattern pricePattern = Pattern.compile(priceRegex);


        double total = 0.0;

        while (!"end of shift".equals(input)) {
            //Matcher store = pattern.matcher(input);
            Matcher nameMatcher = namePattern.matcher(input);
            Matcher productMatcher = productPattern.matcher(input);
            Matcher countMatcher = countPattern.matcher(input);
            Matcher priceMatcher = pricePattern.matcher(input);


            if (nameMatcher.find() &&
            productMatcher.find() &&
            countMatcher.find() &&
            priceMatcher.find()) {
                String name = nameMatcher.group("customerName");
                String product = productMatcher.group("product");
                int count = Integer.parseInt(countMatcher.group("count"));
                double price = Double.parseDouble(priceMatcher.group("price"));

                price = price * count;

                System.out.printf("%s: %s - %.2f%n", name, product, price);

                total = total + price;
            }

            input = scan.nextLine();
        }

        System.out.printf("Total income: %.2f", total);
    }
}
