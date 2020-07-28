import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstList =
                Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondList =
                Arrays.stream(scan.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        int minLength = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < minLength; i++) {
            System.out.print(firstList.get(i) + " ");
            System.out.print(secondList.get(i) + " ");
        }

        printAfterIndex(firstList, minLength);
        printAfterIndex(secondList, minLength);
    }

    private static void printAfterIndex(List<Integer> list, int startIndex) {
        for (int i = startIndex; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
