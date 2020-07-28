import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> users = new HashMap<>();

        while (!"Lumpawaroo".equals(input)) {
            String delimiter = "";

            if (input.contains("|")) {
                String[] tokens = input.split("\\s+\\|\\s+");
                String forceSide = tokens[0];
                String forceUser = tokens[1];

                addUser(forceSide, forceUser, users);
            } else {
                String[] tokens = input.split("\\s+->\\s+");
                String forceUser = tokens[0];
                String forceSide = tokens[1];

                boolean exists = exists(forceUser, users);

                if (exists) {
                    String previousSide = previousSide(forceSide, forceUser, users);
                    users.get(previousSide).remove(forceUser);
                }

                addUser(forceSide, forceUser, users);

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

            }

            input = scan.nextLine();
        }

        users.entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = Integer.compare(i2.getValue().size(), i1.getValue().size());
                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    if (entry.getValue().size() > 0) {
                        System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                        printMembers(entry.getValue());
                    }
                });
    }

    private static void printMembers(List<String> forceUsers) {
        forceUsers.stream()
                .sorted(String::compareTo)
                .forEach(s -> System.out.printf("! %s%n", s));
    }

    private static String previousSide(String forceSide, String forceUser, Map<String, List<String>> users) {
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            if (entry.getValue().contains(forceUser))
                return entry.getKey();
        }
        return "";
    }

    private static boolean exists(String forceUser, Map<String, List<String>> users) {
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            if (entry.getValue().contains(forceUser))
                return true;
        }
        return false;
    }

    private static void addUser(String forceSide, String forceUser, Map<String, List<String>> users) {
        if (!users.containsKey(forceSide)) {
            users.put(forceSide, new LinkedList<>());
        }

        boolean alreadyExists = exists(forceUser, users);

        if (!users.get(forceSide).contains(forceUser) && !alreadyExists) {
            users.get(forceSide).add(forceUser);
        }
    }
}
