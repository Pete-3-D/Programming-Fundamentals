import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        mixLists(firstList, secondList, result);

        int[] constraints = getConstraints(firstList, secondList);

        int leftBound = Math.min(constraints[0], constraints[1]);
        int rightBound = Math.max(constraints[0], constraints[1]);

        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            int currNumber = result.get(i);

            if (currNumber <= leftBound || currNumber >= rightBound) {
                result.remove(i);
                i--;
            }
        }

        printList(result);
    }

    private static void printList(List<Integer> result) {
        for (int number : result)
            System.out.print(number + " ");

        System.out.println();
    }

    private static int[] getConstraints(List<Integer> firstList, List<Integer> secondList) {
        int[] constraints = new int[2];
        List<Integer> remainingNumbers = new ArrayList<>();

        if (!firstList.isEmpty()) {
            remainingNumbers = firstList;
        } else {
            remainingNumbers = secondList;
        }

        constraints[0] = remainingNumbers.get(remainingNumbers.size() - 1);
        constraints[1] = remainingNumbers.get(remainingNumbers.size() - 2);

        return constraints;
    }

    private static void mixLists(List<Integer> firstList, List<Integer> secondList, List<Integer> result) {
        int firstListCondition = 0;
        int secondListCondition = 0;

        if (firstList.size() > secondList.size()) {
            firstListCondition = firstList.size() - 2;
            secondListCondition = 0;
        } else {
            firstListCondition = firstList.size();
            secondListCondition = 2;
        }

        for (int i = 0; i < firstListCondition; i++) {
            result.add(firstList.get(0));
            firstList.remove(0);
        }

        for (int i = secondList.size() - 1; i >= secondListCondition; i--) {
            result.add(secondList.get(secondList.size() - 1));
            secondList.remove((secondList.size() - 1));
        }
    }
}
