import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<String> treasureChest = Arrays.stream(input.split("\\|"))
                                        .collect(Collectors.toList());

        input = scan.nextLine();

        while (!"Yohoho!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Loot": {
                    List<String> items = Arrays.asList(tokens);
                    lootItems(treasureChest, items);
                    break;
                }
                case "Drop": {
                    int index = Integer.parseInt(tokens[1]);
                    dropItem(index, treasureChest);
                    break;
                }
                case "Steal": {
                    int count = Integer.parseInt(tokens[1]);
                    stealItems(count, treasureChest);
                    break;
                }
            }

            input = scan.nextLine();
        }

        //printList(treasureChest);
        printGain(treasureChest);
    }

    private static void printGain(List<String> treasureChest) {
        double totalGain = 0;

        for (String s : treasureChest) {
            totalGain = totalGain + s.length();
        }

        double averageGain = totalGain / treasureChest.size();

        if (averageGain > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        } else {
            System.out.print("Failed treasure hunt.");
        }
    }

    private static void lootItems(List<String> treasureChest, List<String> items) {
        for (int i = 1; i < items.size(); i++) {
            String item = items.get(i);

            if (!treasureChest.contains(item))
                treasureChest.add(0, item);
        }
    }

    private static void printList(List<String> treasureChest) {
        for (int i = 0; i < treasureChest.size(); i++) {
            if (i == 0)
                System.out.printf("%s", treasureChest.get(i));
            else
                System.out.printf(", %s", treasureChest.get(i));
        }
        System.out.println();
    }

    private static void stealItems(int count, List<String> treasureChest) {
        if (count > treasureChest.size())
            count = treasureChest.size();

        List<String> stolenItems = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String item = treasureChest.get(treasureChest.size() - 1);
            stolenItems.add(0, item);
            treasureChest.remove(treasureChest.size() - 1);
        }

        printList(stolenItems);
    }

    private static void dropItem(int index, List<String> treasureChest) {
        if (index < 0 || index > treasureChest.size()) {
            return;
        }

        String temp = treasureChest.get(index);
        treasureChest.remove(index);
        treasureChest.add(temp);
    }
}
