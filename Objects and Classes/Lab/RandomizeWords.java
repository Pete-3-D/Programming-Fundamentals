import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int newPos = 0;
        Random rnd = new Random();

        for (int i = 0; i < input.length; i++) {
            newPos = rnd.nextInt(input.length);
            String temp = input[i];
            input[i] = input[newPos];
            input[newPos] = temp;
        }

        for (String s : input) {
            System.out.println(s);
        }

    }
}
