import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        minutes = minutes + 30;

        if (minutes >= 60) {
            hours++;
            minutes = minutes - 60;
        }

        if (hours >= 24) {
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, minutes);
    }
}
