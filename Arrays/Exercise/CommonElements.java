import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArray = scan.nextLine().split(" ");
        String[] secondArray = scan.nextLine().split(" ");

        for (int i = 0; i < secondArray.length; i++) {
            String toCompare = secondArray[i];
            for (int j = 0; j < firstArray.length; j++) {
                if (toCompare.equals(firstArray[j])) {
                    System.out.printf(toCompare + " ");
                }
            }
        }
    }
}
