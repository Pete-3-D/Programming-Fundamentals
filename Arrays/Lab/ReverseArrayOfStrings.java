import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrStrings = scan.nextLine().split(" ");
        for (int i = arrStrings.length - 1; i >= 0; i--) {
            System.out.printf("%s ", arrStrings[i]);
        }
    }
}
