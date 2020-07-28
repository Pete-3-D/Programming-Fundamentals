import java.util.Scanner;

public class PthBit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        n = n >> b;

        int result = n & 1;

        System.out.println(result);
    }
}
