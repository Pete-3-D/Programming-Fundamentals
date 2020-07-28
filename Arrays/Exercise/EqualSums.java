import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        int[] numbers = new int[text.length];


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(text[i]);
        }

        int index = 0;
        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum = leftSum + numbers[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum = rightSum + numbers[j];
            }

            if (leftSum == rightSum) {
                flag = true;
                index = i;
            }
        }

        if (flag) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
