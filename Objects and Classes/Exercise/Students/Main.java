package Students;

import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String firstName = input[0];
            String secondName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(firstName, secondName, grade);
            students.add(student);
        }

        List<Student> sortedList = students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade)
                .reversed())
                .collect(Collectors.toList());

        sortedList.forEach(s -> System.out.println(s.toString()));
    }
}

