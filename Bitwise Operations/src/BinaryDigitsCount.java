import java.util.Scanner;

public class BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char b = scan.nextLine().charAt(0);

        String binary = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == b)
                count++;
        }

        System.out.println(count);
    }
}
