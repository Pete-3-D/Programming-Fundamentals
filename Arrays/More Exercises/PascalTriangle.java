import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printPascal(n);
    }

    private static void printPascal(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(binomialCoefficient(i, j) + " ");
            }
            System.out.println();
        }
    }

    static int binomialCoefficient(int n, int k)
    {
        int res = 1;

        if (k > n - k)
            k = n - k;

        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

}
