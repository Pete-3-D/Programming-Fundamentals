import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int plunderDays = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double totalPlunder = 0;

        for (int i = 1; i <= plunderDays; i++) {
            totalPlunder = totalPlunder + dailyPlunder;

            if (i % 3 == 0) {
                totalPlunder = totalPlunder + (dailyPlunder * 0.5);
            }

            if (i % 5 == 0) {
                totalPlunder = totalPlunder - (totalPlunder * 0.3);
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double percent = totalPlunder / expectedPlunder * 100.0;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }

    }
}
