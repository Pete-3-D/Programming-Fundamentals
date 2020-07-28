import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine();
        double age = Double.parseDouble(scan.nextLine());
        String result = "";

        if (age >= 0 && age <= 18) {
            if ("Weekday".equals(day)) {
                result = String.format("12$");
            } else if ("Weekend".equals(day)) {
                result = String.format("15$");
            } else if ("Holiday".equals(day)) {
                result = String.format("5$");
            }
        } else if (age >= 18 && age <= 64) {
            if ("Weekday".equals(day)) {
                result = String.format("18$");
            } else if ("Weekend".equals(day)) {
                result = String.format("20$");
            } else if ("Holiday".equals(day)) {
                result = String.format("12$");
            }
        } else if (age > 64 && age <= 122) {
            if ("Weekday".equals(day)) {
                result = String.format("12$");
            } else if ("Weekend".equals(day)) {
                result = String.format("15$");
            } else if ("Holiday".equals(day)) {
                result = String.format("10$");
            }
        } else {
            result = "Error!";
        }

        System.out.println(result);
    }
}
