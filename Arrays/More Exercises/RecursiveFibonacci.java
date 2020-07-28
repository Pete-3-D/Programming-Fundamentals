import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(getFibonacci(n));
    }

    private static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacci(n-1) + getFibonacci(n-2);
    }
}
