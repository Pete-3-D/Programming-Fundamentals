import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int lostGames = Integer.parseInt(input);
        input = scan.nextLine();
        double headsetPrice = Double.parseDouble(input);
        input = scan.nextLine();
        double mousePrice = Double.parseDouble(input);
        input = scan.nextLine();
        double keyboardPrice = Double.parseDouble(input);
        input = scan.nextLine();
        double displayPrice = Double.parseDouble(input);

        double total = 0;
        int countHeadset = 0;
        int countMouse = 0;
        int countKeyboard = 0;
        int countDisplay = 0;

        for (int i = 1; i <= lostGames ; i++) {
            if (i % 2 == 0) {
                countHeadset++;
            }
            if (i % 3 == 0) {
                countMouse++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                countKeyboard++;
                if (countKeyboard % 2 == 0) {
                    countDisplay++;
                }
            }
        }

        total = displayPrice * countDisplay +
                keyboardPrice * countKeyboard +
                mousePrice * countMouse +
                headsetPrice * countHeadset;

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
