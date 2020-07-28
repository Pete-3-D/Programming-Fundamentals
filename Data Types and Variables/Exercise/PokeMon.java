import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pokePower = Integer.parseInt(scan.nextLine()); //N
        int distance = Integer.parseInt(scan.nextLine()); //M
        int exhaustionFactor = Integer.parseInt(scan.nextLine()); //Y

        int count = 0;
        double originalPoke = pokePower;

        while (pokePower >= distance) {
            pokePower = pokePower - distance;
            count++;

            if (pokePower == (originalPoke / 2.0) && exhaustionFactor != 0) {
                if ((pokePower / exhaustionFactor) != 0) {
                    pokePower = pokePower / exhaustionFactor;
                }
            }
        }

        System.out.println(pokePower);
        System.out.println(count);
    }
}
