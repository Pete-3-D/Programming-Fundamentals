import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char nextChar = scan.nextLine().charAt(0);

        if (nextChar >= 97 && nextChar <= 122) {
            System.out.println("lower-case");
        } else if (nextChar >= 65 && nextChar <= 90) {
            System.out.println("upper-case");
        }
    }
}
