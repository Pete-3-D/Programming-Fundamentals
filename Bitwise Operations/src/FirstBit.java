import java.util.Scanner;

public class FirstBit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        n = n >> 1;
        int result = n & 1;

        System.out.println(result);
    }
}
