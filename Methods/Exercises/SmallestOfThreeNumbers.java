import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());

        smallestOfThree(first, second, third);
    }

    private static void smallestOfThree(int first, int second, int third) {
        int smallest = first;

        if (second < first)
            smallest = second;

        if (third < second)
            smallest = third;

        System.out.println(smallest);
    }
}
