import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> time = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double leftTotal = 0;
        for (int i = 0; i < time.size() / 2; i++) {
            leftTotal = leftTotal + time.get(i);

            if (time.get(i) == 0) {
                leftTotal = leftTotal * 0.80;
            }
        }

        double rightTotal = 0;
        for (int i = time.size() - 1; i > time.size() / 2; i--) {
            rightTotal = rightTotal + time.get(i);

            if (time.get(i) == 0) {
                rightTotal = rightTotal * 0.80;
            }
        }

        String winner = "";
        double total = 0;
        if (leftTotal < rightTotal) {
            winner = "left";
            total = leftTotal;
        } else {
            winner = "right";
            total = rightTotal;
        }

        System.out.printf("The winner is %s with total time: %.1f", winner, total);
    }
}
