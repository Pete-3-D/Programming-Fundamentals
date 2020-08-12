import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\|");
            String carName = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carMileage.put(carName, mileage);
            carFuel.put(carName, fuel);
        }

        String input = scan.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];

            switch (command) {
                case "Drive": {
                    String carName = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    int currFuel = carFuel.get(carName);
                    int newFuel = currFuel - fuel;
                    if (newFuel >= 0) {
                        int currMileage = carMileage.get(carName);
                        int newMileage = distance + currMileage;
                        carMileage.put(carName, newMileage);
                        carFuel.put(carName, newFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                carName,
                                distance,
                                fuel);

                        if (newMileage >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            carMileage.remove(carName);
                            carFuel.remove(carName);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                }
                case "Refuel": {
                    String carName = tokens[1];
                    int fuel = Integer.parseInt(tokens[2]);

                    int currFuel = carFuel.get(carName);
                    int newFuel = currFuel + fuel;

                    if (newFuel > 75)
                        newFuel = 75;

                    carFuel.put(carName, newFuel);
                    System.out.printf("%s refueled with %d liters%n", carName, newFuel - currFuel);
                    break;
                }
                case "Revert": {
                    String carName = tokens[1];
                    int kilometers = Integer.parseInt(tokens[2]);

                    int currMileage = carMileage.get(carName);
                    int newMileage = currMileage - kilometers;

                    if (newMileage >= 10000) {
                        carMileage.put(carName, newMileage);
                        System.out.printf("%s mileage decreased by %d kilometers%n",
                                carName,
                                kilometers);
                    } else {
                        newMileage = 10000;
                        carMileage.put(carName, newMileage);
                    }
                    break;
                }
            }

            input = scan.nextLine();
        }

        carMileage.entrySet().stream().sorted((c1, c2) -> {
            int result = c2.getValue().compareTo(c1.getValue());
            if (result == 0)
                result = c1.getKey().compareTo(c2.getKey());
            return result;
        }).forEach(c -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                c.getKey(),
                c.getValue(),
                carFuel.get(c.getKey())));
    }
}
