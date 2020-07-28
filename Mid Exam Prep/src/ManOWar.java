import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<Integer> pirateShip = Arrays.stream(input.split(">"))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        input = scan.nextLine();
        List<Integer> warship = Arrays.stream(input.split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        input = scan.nextLine();
        int maximumHealth = Integer.parseInt(input);

        input = scan.nextLine();

        while (!"Retire".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Fire": {
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    boolean end = fire(warship, index, damage);

                    if (end)
                        return;

                    break;
                }
                case "Defend": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damage = Integer.parseInt(tokens[3]);
                    boolean end = defendShip(pirateShip, startIndex, endIndex, damage);

                    if (end)
                        return;

                    break;
                }
                case "Repair": {
                    int index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    repairSection(pirateShip, index, health, maximumHealth);
                    break;
                }
                case "Status":
                    printSections(pirateShip, maximumHealth);
                    break;
            }

            input = scan.nextLine();
        }

        System.out.printf("Pirate ship status: %d%n", sumSections(pirateShip));
        System.out.printf("Warship status: %d%n", sumSections(warship));

    }

    private static int sumSections(List<Integer> pirateShip) {
        int sum = 0;

        for (int section : pirateShip) {
            sum = sum + section;
        }

        return sum;
    }

    private static boolean defendShip(List<Integer> pirateShip, int startIndex, int endIndex, int damage) {
        if (startIndex < 0 || startIndex >= pirateShip.size())
            return false;

        if (endIndex < 0 || endIndex >= pirateShip.size())
            return false;

        for (int i = startIndex; i <= endIndex; i++) {
            int currentSection = pirateShip.get(i);

            if (currentSection - damage <= 0) {
                System.out.println("You lost! The pirate ship has sunken.");
                return true;
            }

            currentSection = currentSection - damage;
            pirateShip.set(i, currentSection);
        }

        return false;
    }

    private static void repairSection(List<Integer> pirateShip, int index, int health, int maximumHealth) {
        if (index < 0 || index >= pirateShip.size())
            return;

        if (health > maximumHealth)
            health = maximumHealth;
        else
            health = health + pirateShip.get(index);

        pirateShip.set(index, health);
    }

    private static void printSections(List<Integer> pirateShip, int maximumHealth) {
        int count = 0;
        for (int section : pirateShip) {
            if (section < (maximumHealth * 0.2)) {
                count++;
            }
        }
        System.out.printf("%d sections need repair.", count);
        System.out.println();
    }

    private static boolean fire(List<Integer> warship, int index, int damage) {
        if (index < 0 || index >= warship.size())
            return false;

        int newStatus = warship.get(index) - damage;

        if (newStatus <= 0) {
            System.out.println("You won! The enemy ship has sunken.");
            return true;
        }

        warship.set(index, newStatus);
        return false;
    }
}
