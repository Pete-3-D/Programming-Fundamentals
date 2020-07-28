import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sumLiters = 0;

        for (int i = 0; i < n; i++) {
            int quantityWater = Integer.parseInt(scan.nextLine());
            if (255 - (sumLiters + quantityWater) >= 0) {
                sumLiters = sumLiters + quantityWater;
            } else {
                System.out.println("Insufficient capacity!");
                continue;
            }
        }

        System.out.println(sumLiters);
    }
}
