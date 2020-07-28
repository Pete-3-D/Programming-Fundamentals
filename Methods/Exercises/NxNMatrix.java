import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        printMatrix(n);
    }

    private static void printMatrix(int n) {
        for (int i = 0; i < n; i++) {
            printRow(n);
            System.out.println();
        }
    }

    private static void printRow(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", n);
        }
    }
}
