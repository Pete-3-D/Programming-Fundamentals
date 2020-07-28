import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junk = new HashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean isObtained = false;

        while (!isObtained) {
            String[] input = scan.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (keyMaterials.containsKey(material)) {
                    addMaterials(keyMaterials, material, quantity);
                    isObtained = isObtained(isObtained, keyMaterials, material);
                } else {
                    addMaterials(junk, material, quantity);
                }

                if (isObtained) {
                    String legendary = "";
                    switch (material) {
                        case "shards":
                            legendary = "Shadowmourne";
                            break;
                        case "fragments":
                            legendary = "Valanyr";
                            break;
                        case "motes":
                            legendary = "Dragonwrath";
                            break;
                    }
                    System.out.printf("%s obtained!%n", legendary);
                    break;
                }
            }
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = i2.getValue().compareTo(i1.getValue());
                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));

        junk.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
    }

    private static boolean isObtained(boolean isObtained, Map<String, Integer> materials, String material) {
        if (materials.get(material) >= 250) {
            int newQuantity = materials.get(material) - 250;
            materials.put(material, newQuantity);
            return true;
        }
        return false;
    }

    private static void addMaterials(Map<String, Integer> materials, String material, int quantity) {
        if (!materials.containsKey(material)) {
            materials.put(material, quantity);
        } else {
            materials.put(material, materials.get(material) + quantity);
        }
    }
}
