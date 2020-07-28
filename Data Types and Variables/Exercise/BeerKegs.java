import java.math.BigDecimal;
import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String biggestKeg = "";
        double biggestVolume = 0;

        for (int i = 0; i < n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > biggestVolume) {
                biggestKeg = model;
                biggestVolume = volume;
            }
        }

        System.out.println(biggestKeg);
    }
}
