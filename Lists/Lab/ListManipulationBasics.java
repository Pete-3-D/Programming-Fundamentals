import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        String input = scan.nextLine();

        while(!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int temp = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add":
                    numbers.add(temp);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(temp));
                    break;
                case "RemoveAt":
                    numbers.remove(temp);
                    break;
                case "Insert":
                    int temp2 = Integer.parseInt(tokens[2]);
                    numbers.add(temp2, temp);
                    break;
            }

            input = scan.nextLine();
        }

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
