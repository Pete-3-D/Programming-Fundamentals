import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double bestSnowballValue = 0;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());

            double snowballValue = Math.pow((snowballSnow / snowballTime), snowballQuality);
            if (snowballValue > bestSnowballValue) {
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
                bestSnowballValue = snowballValue;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)",
                bestSnowballSnow, bestSnowballTime, bestSnowballValue, bestSnowballQuality);
    }
}
