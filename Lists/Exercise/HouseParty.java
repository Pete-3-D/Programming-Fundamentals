import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nCommands = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < nCommands; i++) {
            String command = scan.nextLine();
            String[] tokens = command.split("\\s+");
            String name = tokens[0];

            if ("not".equals(tokens[2])) {
                if (guests.contains(name))
                    guests.remove(name);
                else
                    System.out.println(name + " is not in the list!");
            } else {
                if (guests.contains(name))
                    System.out.println(name + " is already in the list!");
                else
                    guests.add(name);
            }
        }
        
        printList(guests);
    }

    private static void printList(List<String> guests) {
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
