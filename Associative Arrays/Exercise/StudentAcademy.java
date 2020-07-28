import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, ArrayList<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }

            students.get(name).add(grade);

        }

        Map<String, Double> toPrint = calculateAvg(students);

        toPrint.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .forEach(i -> System.out.printf("%s -> %.2f%n", i.getKey(), i.getValue()));
    }

    private static Map<String, Double> calculateAvg(Map<String, ArrayList<Double>> students) {
        Map<String, Double> toPrint = new LinkedHashMap<>();

        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            double avg = calculateSum(entry.getValue()) / entry.getValue().size();
            if (avg >= 4.50)
                toPrint.put(entry.getKey(), avg);
        }

        return toPrint;
    }

    private static double calculateSum(ArrayList<Double> value) {
        double sum = 0;

        for (double d : value) {
            sum = sum + d;
        }

        return sum;
    }
}
