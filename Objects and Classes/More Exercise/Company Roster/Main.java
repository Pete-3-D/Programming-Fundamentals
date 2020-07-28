// problem is way above my level but I had already started when I realized that
// managed to populate the list myself but the rest of the solution belongs to mark79 (https://pastebin.com/zwjSiV7r)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Employee> employees = new ArrayList<>();

        populateList(employees, n, scan);
        Department department = calculateHighestAverageSalary(employees);

        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());

        for (Employee employee : department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }

    private static Department calculateHighestAverageSalary(List<Employee> employees) {
        List<String> departmentsList = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList()); // get list of unique department names

        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department, employees.stream()
                                                        .filter(employee -> employee.getDepartment().equals(department))
                                                        .collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());

        return departments.get(0);
    }

    private static void populateList(List<Employee> employees, int n, Scanner scan) {
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email = "";
            int age = 0;

            if (tokens.length >= 5) {
                String token = checkToken(tokens, 4);
                if ("email".equals(token))
                    email = tokens[4];
                else if ("age".equals(token))
                    age = Integer.parseInt(tokens[4]);
                if (tokens.length == 6) {
                    token = checkToken(tokens, 5);
                    if ("email".equals(token))
                        email = tokens[5];
                    else if ("age".equals(token))
                        age = Integer.parseInt(tokens[5]);
                }
            }

            Employee employee;

            if (email.length() != 0 && age != 0) { // full
                employee = new Employee(name, salary, position, department, email, age);
            } else if (email.length() != 0) { // age == 0
                employee = new Employee(name, salary, position, department, email);
            } else if (age != 0) { // email blank
                employee = new Employee(name, salary, position, department, age);
            } else { // email blank && age == 0
                employee = new Employee(name, salary, position, department);
            }

            employees.add(employee);
        }
    }

    private static String checkToken(String[] tokens, int index) {
        if (tokens[index].contains("@"))
            return "email";
        else
            return "age";
    }
}
