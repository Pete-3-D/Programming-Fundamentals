import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        String delimiter = scan.nextLine();

        String result = firstName + delimiter + lastName;

        System.out.printf("%s", result);
    }
}
