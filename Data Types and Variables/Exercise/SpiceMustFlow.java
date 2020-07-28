import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine());
        int days = 0;
        long totalYield = 0L;

        if (startingYield >= 100) {
            while (startingYield >= 100) {
                totalYield = totalYield + startingYield - 26;
                startingYield = startingYield - 10;
                days++;
            }
            totalYield = totalYield - 26;
        }

        System.out.println(days);
        System.out.println(totalYield);
    }
}
