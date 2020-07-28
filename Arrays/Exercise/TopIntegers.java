import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        int[] numbers = new int[text.length];


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(text[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean isBigger = true;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
