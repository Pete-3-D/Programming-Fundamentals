import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());
        
        printGrade(grade);
    }

    private static void printGrade(double grade) {
        String result = "";

        if (grade >= 2 && grade < 3) {
            result = "Fail";
        } else if (grade >= 3 && grade < 3.50) {
            result = "Poor";
        } else if (grade >= 3.50 && grade < 4.50) {
            result = "Good";
        } else if (grade >= 4.50 && grade < 5.50) {
            result = "Very good";
        } else if (grade >= 5.50) {
            result = "Excellent";
        }

        System.out.println(result);
    }
}
