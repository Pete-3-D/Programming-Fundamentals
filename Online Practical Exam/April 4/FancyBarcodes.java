import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "(@#+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern barcodeFinder = Pattern.compile(regex);
            Matcher matcher = barcodeFinder.matcher(input);

            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                String productGroup = extractDigits(barcode);

                if ("".equals(productGroup))
                    productGroup = "00";

                System.out.printf("Product group: %s%n", productGroup);
            } else
                System.out.println("Invalid barcode");
        }
    }

    private static String extractDigits(String barcode) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < barcode.length(); i++) {
            if (Character.isDigit(barcode.charAt(i))) {
                sb.append(barcode.charAt(i));
            }
        }

        return sb.toString();
    }
}
