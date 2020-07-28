import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<Vehicle> catalogue = new ArrayList<>();

        while (!"End".equals(input)) {
            // {typeOfVehicle} {model} {color} {horsepower}
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            catalogue.add(vehicle);

            input = scan.nextLine();
        }

        input = scan.nextLine();

        double truckAvgHrsp = 0;
        int truckCount = 0;

        double carAvgHrsp = 0;
        int carCount = 0;

        while (!"Close the Catalogue".equals(input)) {
            for (Vehicle v : catalogue) {
                if (v.getModel().equals(input))
                    System.out.println(v.toString());
            }

            input = scan.nextLine();
        }

        for (Vehicle v : catalogue) {
            if ("car".equals(v.getType())) {
                carAvgHrsp = carAvgHrsp + v.getHorsepower();
                carCount++;
            }
            if ("truck".equals(v.getType())) {
                truckAvgHrsp = truckAvgHrsp + v.getHorsepower();
                truckCount++;
            }
        }

        if (carCount > 0) {
            carAvgHrsp = carAvgHrsp / carCount;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", carAvgHrsp);

        if (truckCount > 0) {
            truckAvgHrsp = truckAvgHrsp / truckCount;
        }

        System.out.printf("Trucks have average horsepower of: %.2f.", truckAvgHrsp);
    }
}
