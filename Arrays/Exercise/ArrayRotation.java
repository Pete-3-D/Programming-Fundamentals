import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rotations; i++) {
            String temp = input[0];
            for (int j = 0; j < input.length - 1; j++) {
                input[j] = input[j + 1];
            }
            input[input.length - 1] = temp;
        }

        System.out.println(String.join(" ", input));
    }
}
