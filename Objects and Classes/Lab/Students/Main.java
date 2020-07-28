import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<Student> students = new ArrayList<>();

        while (!"end".equals(input)) {
            // John Smith 15 Sofia
            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];

            Student student = new Student(firstName, lastName, age, hometown);
            students.add(student);

            input = scan.nextLine();
        }

        input = scan.nextLine(); // city name

        for (Student s : students) {
            if (input.equals(s.getHometown())) {
                System.out.printf("%s %s is %d years old%n",
                        s.getFirstName(), s.getLastName(), s.getAge());
            }
        }

        //Print only students which are from the given city, in the following format: "{firstName} {lastName} is {age} years old.".
    }
}
