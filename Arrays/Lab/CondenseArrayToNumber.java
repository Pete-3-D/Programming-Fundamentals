import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;

        while (nums.length > 1) {
            int[] condensed = new int[nums.length - 1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = nums[i] + nums[i+1];
            }
            nums = condensed;
        }

        sum = nums[0];
        System.out.println(sum);
    }
}
