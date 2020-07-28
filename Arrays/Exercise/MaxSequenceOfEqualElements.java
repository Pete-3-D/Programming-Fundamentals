import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        int[] numbers = new int[text.length];


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(text[i]);
        }

        int currentLength = 1;
        int biggestLength = 1;
        int digit = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i+1]) {
                currentLength++;
                if (currentLength > biggestLength) {
                    biggestLength = currentLength;
                    digit = numbers[i];
                }
            } else {
                currentLength = 1;
            }
        }

        for (int i = 0; i < biggestLength; i++) {
            System.out.printf(digit + " ");
        }

    }
}
