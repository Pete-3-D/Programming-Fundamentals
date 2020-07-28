import java.util.Scanner;

public class TriBitSwitch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int p = Integer.parseInt(scan.nextLine());
        int mask = 7 << p;
        int result = n ^ mask;

        System.out.println(result);
    }
}
