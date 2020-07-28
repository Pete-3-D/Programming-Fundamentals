import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scan.nextLine());
        int secondEmployee = Integer.parseInt(scan.nextLine());
        int thirdEmployee = Integer.parseInt(scan.nextLine());
        int efficiency = firstEmployee + secondEmployee + thirdEmployee;

        int countStudents = Integer.parseInt(scan.nextLine());

        //countStudents = countStudents - efficiency;
        int hours = 0;

        while (countStudents > 0) {
            countStudents = countStudents - efficiency;
            hours++;

            if (hours % 4 == 0) {
                hours++;
            }
        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
