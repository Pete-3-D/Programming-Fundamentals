import com.sun.source.tree.Tree;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        TreeMap<String, List<String>> company = new TreeMap<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+->\\s+");

            String companyName = tokens[0];
            String employeeId = tokens[1];

            if (!company.containsKey(companyName)) {
                company.put(companyName, new LinkedList<>());
            }

            if (!company.get(companyName).contains(employeeId)) {
                company.get(companyName).add(employeeId);
            }

            input = scan.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : company.entrySet()) {
            System.out.println(entry.getKey());
            List<String> employees = entry.getValue();
            employees.stream()
                    .forEach(i -> System.out.printf("-- %s\n", i));
        }
    }
}
