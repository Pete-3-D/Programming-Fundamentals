import java.util.Scanner;

public class OddTimes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numsAsString = scan.nextLine().split(" ");
        int[] nums = new int[numsAsString.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numsAsString[i]);
        }

        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        System.out.println(result);
    }
}
