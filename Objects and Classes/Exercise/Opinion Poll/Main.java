import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            if (person.getAge() > 30)
                people.add(person);
        }

        people = people
                .stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());

        for (Person p : people)
            System.out.println(p.toString());
    }
}
