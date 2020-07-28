import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int nPeople = Integer.parseInt(input);

        input = scan.nextLine();
        String typeOfGroup = input;

        input = scan.nextLine();
        String dayOfWeek = input;

        double singlePrice = 0;
        double total = 0;

        if ("Friday".equals(dayOfWeek)) {
            if ("Students".equals(typeOfGroup)) {
                singlePrice = 8.45;
                if (nPeople >= 30) {
                    singlePrice = singlePrice - (singlePrice * 0.15);
                }
            } else if ("Business".equals(typeOfGroup)) {
                singlePrice = 10.90;
                if (nPeople >= 100) {
                    nPeople = nPeople - 10;
                }
            } else if ("Regular".equals(typeOfGroup)) {
                singlePrice = 15;
                if (nPeople >= 10 && nPeople <= 20) {
                    singlePrice = singlePrice - (singlePrice * 0.05);
                }
            }
        } else if ("Saturday".equals(dayOfWeek)) {
            if ("Students".equals(typeOfGroup)) {
                singlePrice = 9.80;
                if (nPeople >= 30) {
                    singlePrice = singlePrice - (singlePrice * 0.15);
                }
            } else if ("Business".equals(typeOfGroup)) {
                singlePrice = 15.60;
                if (nPeople >= 100) {
                    nPeople = nPeople - 10;
                }
            } else if ("Regular".equals(typeOfGroup)) {
                singlePrice = 20;
                if (nPeople >= 10 && nPeople <= 20) {
                    singlePrice = singlePrice - (singlePrice * 0.05);
                }
            }
        } else if ("Sunday".equals(dayOfWeek)) {
            if ("Students".equals(typeOfGroup)) {
                singlePrice = 10.46;
                if (nPeople >= 30) {
                    singlePrice = singlePrice - (singlePrice * 0.15);
                }
            } else if ("Business".equals(typeOfGroup)) {
                singlePrice = 16;
                if (nPeople >= 100) {
                    nPeople = nPeople - 10;
                }
            } else if ("Regular".equals(typeOfGroup)) {
                singlePrice = 22.50;
                if (nPeople >= 10 && nPeople <= 20) {
                    singlePrice = singlePrice - (singlePrice * 0.05);
                }
            }
        }

        total = nPeople * singlePrice;
        System.out.printf("Total price: %.2f", total);
    }
}
