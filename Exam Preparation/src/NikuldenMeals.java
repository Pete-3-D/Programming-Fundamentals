import java.util.*;

public class NikuldenMeals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, List<String>> guests = new LinkedHashMap<>();
        int unlikedMeals = 0;

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];

            if ("Like".equals(command)) {
                if (!guests.containsKey(guest))
                    guests.putIfAbsent(guest, new LinkedList<>());

                if (!guests.get(guest).contains(meal))
                    guests.get(guest).add(meal);
            } else if ("Unlike".equals(command)) {
                if (!guests.containsKey(guest))
                    System.out.printf("%s is not at the party.%n", guest);
                else if (!guests.get(guest).contains(meal))
                    System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                else {
                    guests.get(guest).remove(meal);
                    System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    unlikedMeals++;
                }
            }

            input = scan.nextLine();
        }

        guests.entrySet().stream().sorted((g1, g2) -> {
            Integer size1 = g1.getValue().size();
            Integer size2 = g2.getValue().size();

            int result = size2.compareTo(size1);

            if (result == 0) {
                result = g1.getKey().compareTo(g2.getKey());
            }

            return result;
        }).forEach(g -> {
            System.out.printf("%s: ", g.getKey());
            System.out.println(String.join(", ", g.getValue()));
        });

        System.out.printf("Unliked meals: %d%n", unlikedMeals);
    }
}
