import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, List<String>> database = new TreeMap<>();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];

            switch (command) {
                case "Add": {
                    String username = tokens[1];
                    if (database.containsKey(username))
                        System.out.printf("%s is already registered%n", username);
                    else
                        database.put(username, new LinkedList<>());
                    break;
                }
                case "Send": {
                    String username = tokens[1];
                    String email = tokens[2];
                    database.get(username).add(email);
                    break;
                }
                case "Delete": {
                    String username = tokens[1];
                    if (!database.containsKey(username))
                        System.out.printf("%s not found!%n", username);
                    else
                        database.remove(username);
                    break;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("Users count: %d%n", database.size());
        database.entrySet().stream().sorted((u1, u2) -> {
            int result = Integer.compare(u2.getValue().size(), u1.getValue().size());
            if (result == 0)
                result = u1.getKey().compareTo(u2.getKey());
            return result;
        }).forEach(u -> {
            System.out.println(u.getKey());
            for (String s : u.getValue()) {
                System.out.printf(" - %s%n", s);
            }
        });
    }
}
