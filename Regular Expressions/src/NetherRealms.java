// Solution belongs to geoboz (https://softuni.bg/forum/questions/details/31554)
// Much simpler with a class
// Not entirely sure what I messed up earlier since this is miles better.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] strings = input.nextLine().split(",\\s*");

        //Regex expressions for validation
        String nameRegex = "[^ ,]+";
        String healthRegex = "[^0-9+\\-*/.]";
        String damageRegex = "[+|-]?\\d+\\.?\\d*";
        String damageCorrRegex = "[*/]";

        //Patterns declaration
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern healthPattern = Pattern.compile(healthRegex);
        Pattern damagePattern = Pattern.compile(damageRegex);
        Pattern damageCorrPattern = Pattern.compile(damageCorrRegex);

        //Adding only valid names in a list
        List<String> validNames = new ArrayList<>();
        for (String string : strings) {
            Matcher matcher = namePattern.matcher(string);
            if (matcher.find()) {
                validNames.add(string.trim());
            }
        }

        //Creating a list to hold all Daemons
        List<Daemon> participants = new ArrayList<>();

        //Iterating over the valid names to get each Daemon's properties
        for (String name : validNames) {

            //Getting health value
            Matcher matcher = healthPattern.matcher(name);
            int health = 0;
            while (matcher.find()) {
                char ch = matcher.group().charAt(0);
                health += ch;
            }

            //Getting damage value
            double damage = 0.0;
            matcher = damagePattern.matcher(name);
            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            //Correct the damage if there are '*' or '/' chars
            matcher = damageCorrPattern.matcher(name);
            while (matcher.find()) {
                switch (matcher.group()) {
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                    default:
                        break;
                }
            }

            //Creating a Daemon instance and adding it to the list
            Daemon daemon = new Daemon(name, health, damage);
            participants.add(daemon);

        }

        //Sorting and printing all participating Daemons
        participants.sort(Comparator.comparing(Daemon::getName));
        participants.forEach(daemon -> System.out.printf("%s - %d health, %.2f damage%n",
                daemon.getName(),
                daemon.getHealth(),
                daemon.getDamage()));


    } //end of main

    //Class Daemon description
    static class Daemon {
        String name;
        int health;
        double damage;

        public Daemon(String name, int health, double damage) {
            this.name = name;
            this.health = health;
            this.damage = damage;
        }

        String getName() {
            return this.name;
        }

        public int getHealth() {
            return health;
        }

        public double getDamage() {
            return damage;
        }
    }
}
