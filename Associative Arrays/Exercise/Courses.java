import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, ArrayList<String>> courses = new LinkedHashMap<>();

        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }

            courses.get(courseName).add(studentName);

            input = scan.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((i1, i2) -> Integer.compare(i2.getValue().size(), i1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), courses.get(entry.getKey()).size());
                    printStudents(courses.get(entry.getKey()));
                });

    }

    private static void printStudents(ArrayList<String> students) {
        students.stream()
                .sorted(String::compareTo)
                .forEach(s -> System.out.printf("-- %s%n", s));
    }
}
