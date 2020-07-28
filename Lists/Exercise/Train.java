import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");

            if ("Add".equals(tokens[0])) {
                int passengers = Integer.parseInt(tokens[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(tokens[0]);
                addPassengers(maxCapacity, passengers, wagons);
            }

            input = scan.nextLine();
        }

        printList(wagons);
    }

    private static void addPassengers(int maxCapacity, int passengers, List<Integer> wagons) {
        for (int i = 0; i < wagons.size(); i++) {
            int currentPassengers = wagons.get(i);

            if (passengers + currentPassengers <= maxCapacity) {
                wagons.set(i, passengers + currentPassengers);
                break;
            }
        }
    }

    private static void printList(List<Integer> wagons) {
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
