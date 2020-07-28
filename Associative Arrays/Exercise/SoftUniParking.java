import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> parkingData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];

            if ("register".equals(command)) {
                String licencePlate = tokens[2];
                if (!parkingData.containsKey(username)) {
                    parkingData.put(username, licencePlate);
                    System.out.printf("%s registered %s successfully%n", username, licencePlate);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", parkingData.get(username));
                }
            } else {
                if (parkingData.containsKey(username)) {
                    parkingData.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                } else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }
        }

        parkingData.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));

    }
}
