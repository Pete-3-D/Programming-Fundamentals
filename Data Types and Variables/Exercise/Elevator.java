import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());

        int courses = people / capacity;

        if (people % capacity != 0) {
            courses = courses + 1;
        }

        System.out.printf("%d", courses);
    }
}

