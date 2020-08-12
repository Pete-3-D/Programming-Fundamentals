import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> heroesHealth = new LinkedHashMap<>();
        Map<String, Integer> heroesMana = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");

            String heroName = tokens[0];
            int healthPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);

            heroesHealth.put(heroName, healthPoints);
            heroesMana.put(heroName, manaPoints);
        }

        String input = scan.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "CastSpell": {
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    castSpell(heroesMana, heroName, mpNeeded, spellName);
                    break;
                }
                case "TakeDamage": {
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    takeDamage(heroesHealth, heroesMana, heroName, damage, attacker);
                    break;
                }
                case "Recharge": {
                    int amount = Integer.parseInt(tokens[2]);
                    recharge(heroesMana, heroName, amount);
                    break;
                }
                case "Heal": {
                    int amount = Integer.parseInt(tokens[2]);
                    heal(heroesHealth, heroName, amount);
                    break;
                }
            }

            input = scan.nextLine();
        }

        heroesHealth.entrySet().stream().sorted((h1, h2) -> {
            int result = h2.getValue().compareTo(h1.getValue());

            if (result == 0)
                result = h1.getKey().compareTo(h2.getKey());

            return result;
        }).forEach(h -> System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                h.getKey(),
                h.getValue(),
                heroesMana.get(h.getKey())));
    }

    private static void heal(Map<String, Integer> heroesHealth, String heroName, int amount) {
        int currHealth = heroesHealth.get(heroName);
        int newHealth = currHealth + amount;

        if (newHealth > 100)
            newHealth = 100;

        System.out.printf("%s healed for %d HP!%n",
                heroName,
                newHealth - currHealth);
        heroesHealth.put(heroName, newHealth);
    }

    private static void recharge(Map<String, Integer> heroesMana, String heroName, int amount) {
        int currMana = heroesMana.get(heroName);
        int newMana = currMana + amount;

        if (newMana > 200)
            newMana = 200;

        System.out.printf("%s recharged for %d MP!%n",
                heroName,
                newMana - currMana);
        heroesMana.put(heroName, newMana);
    }

    private static void takeDamage(Map<String, Integer> heroesHealth, Map<String, Integer> heroesMana, String heroName, int damage, String attacker) {
        int currHealth = heroesHealth.get(heroName);
        int newHealth = currHealth - damage;

        if (newHealth > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                    heroName,
                    damage,
                    attacker,
                    newHealth);
            heroesHealth.put(heroName, newHealth);
        } else {
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
            heroesHealth.remove(heroName);
            heroesMana.remove(heroName);
        }

    }

    private static void castSpell(Map<String, Integer> heroesMana, String heroName, int neededMana, String spellName) {
        int currMana = heroesMana.get(heroName);

        if (currMana >= neededMana) {
            int newMana = currMana - neededMana;
            heroesMana.put(heroName, newMana);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                    heroName,
                    spellName,
                    newMana);
        } else
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
    }
}
