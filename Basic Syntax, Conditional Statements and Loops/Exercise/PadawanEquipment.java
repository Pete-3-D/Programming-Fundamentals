import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double budget = Double.parseDouble(input);
        input = scan.nextLine();
        int nStudents = Integer.parseInt(input);
        input = scan.nextLine();
        double priceLightsaber = Double.parseDouble(input);
        input = scan.nextLine();
        double priceRobe = Double.parseDouble(input);
        input = scan.nextLine();
        double priceBelt = Double.parseDouble(input);

        double total = 0;
        int countLightsabers = nStudents;
        int countBelts = nStudents;
        int countRobes = nStudents;

        countLightsabers = (int) Math.ceil(countLightsabers * 1.10);

        if (nStudents >= 6) {
            countBelts = countBelts - (countBelts / 6);
        }

        total = priceBelt * countBelts +
                priceLightsaber * countLightsabers +
                priceRobe * countRobes;

        if (total <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", total - budget);
        }


    }
}
