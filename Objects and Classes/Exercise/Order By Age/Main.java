import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> people = new ArrayList<>();

        while(!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, id, age);
            people.add(person);

            input = scan.nextLine();
        }

        people = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        for (Person p : people)
            System.out.println(p.toString());
    }
}
