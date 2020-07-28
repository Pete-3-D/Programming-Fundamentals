import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int highestNumber = Integer.parseInt(scan.nextLine());

        printTop(highestNumber);
        printBottom(highestNumber);
    }

    private static void printTop(int highestNumber) {
        for (int i = 1; i <= highestNumber; i++) {
            printRow(i);
            System.out.println();
        }
    }

    private static void printBottom(int highestNumber) {
        for (int i = highestNumber - 1; i >= 1; i--) {
            printRow(i);
            System.out.println();
        }
    }

    private static void printRow(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.printf("%d ", i);
        }
    }
}
