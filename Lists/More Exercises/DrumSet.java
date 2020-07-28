import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> drumSet = Arrays.stream(scan.nextLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());
        List<Integer> initialQuality = new ArrayList<>(drumSet);

        String input = scan.nextLine();

        while (!"Hit it again, Gabsy!".equals(input)) {
            int hitPower = Integer.parseInt(input);
            decreaseValue(drumSet, hitPower);

            savings = checkBroken(drumSet, initialQuality, savings);

            input = scan.nextLine();
        }

        printList(drumSet);
        System.out.printf("Gabsy has %.2flv.", savings);
    }

    private static void printList(List<Integer> drumSet) {
        for (int drum : drumSet) {
            System.out.print(drum + " ");
        }
        System.out.println();
    }

    private static double checkBroken(List<Integer> drumSet, List<Integer> initialQuality, double savings) {
        for (int i = 0; i < drumSet.size(); i++) {
            int currValue = drumSet.get(i);

            if (currValue == 0) { // if broken
                int quality = initialQuality.get(i);
                double price = quality * 3; // get price

                if (savings >= price) { // check if she can afford it
                    savings = savings - price; // buy new drum
                    drumSet.set(i, quality); // replace old one
                } else {
                    drumSet.remove(i);
                    initialQuality.remove(i);
                    i--;
                }
            }
        }

        return savings;
    }

    private static void decreaseValue(List<Integer> drumSet, int hitPower) {
        for (int i = 0; i < drumSet.size(); i++) {
            int currValue = drumSet.get(i);
            drumSet.set(i, Math.max(currValue - hitPower, 0));
        }
    }
}
