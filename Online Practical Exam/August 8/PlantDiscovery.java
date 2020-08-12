// fuck this problem in particular.

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> plantRarity = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            plantRarity.put(plant, rarity);
        }

        String input = scan.nextLine();
        Map<String, LinkedList<Integer>> plantRatings = new LinkedHashMap<>();

        while (!"Exhibition".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Rate:": {
                    String plant = tokens[1];
                    int rating = Integer.parseInt(tokens[3]);

                    if (plantRarity.containsKey(plant)) {

                        if (!plantRatings.containsKey(plant))
                            plantRatings.put(plant, new LinkedList<>());

                        plantRatings.get(plant).add(rating);
                    }

                    break;
                }
                case "Update:": {
                    String plant = tokens[1];
                    int rarity = Integer.parseInt(tokens[3]);

                    if (plantRarity.containsKey(plant))
                        plantRarity.put(plant, rarity);

                    break;
                }
                case "Reset:": {
                    String plant = tokens[1];

                    if (plantRatings.containsKey(plant))
                        plantRatings.get(plant).clear();

                    break;
                }
            }

            input = scan.nextLine();
        }

        List<Plant> plants = new LinkedList<>();

        for (Map.Entry<String, LinkedList<Integer>> entry : plantRatings.entrySet()) {
            String plant = entry.getKey();
            int rarity = plantRarity.get(plant);
            double rating = calculateAverage(entry.getValue());

            Plant p = new Plant(plant, rarity, rating);
            plants.add(p);
        }

        System.out.println("Plants for the exhibition:");
        plants.sort((p1, p2) -> {
            int result = Integer.compare(p2.rarity, p1.rarity);

            if (result == 0)
                result = Double.compare(p2.rating, p1.rating);

            return result;
        });
        plants.forEach(p -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                p.name,
                p.rarity,
                p.rating));
    }

    private static double calculateAverage(LinkedList<Integer> integers) {
        OptionalDouble average = integers
                .stream()
                .mapToDouble(a -> a)
                .average();

        return average.isPresent() ? average.getAsDouble() : 0.0;
    }

    static class Plant {
        String name;
        int rarity;
        double rating;

        public Plant(String name, int rarity, double rating) {
            this.name = name;
            this.rarity = rarity;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }
}
