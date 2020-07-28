import java.util.Scanner;

public class PassedOrFailed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float grade = Float.parseFloat(scan.nextLine());

        if (grade >= 3) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
