import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        StringBuilder sb = new StringBuilder();
        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                power = power + Integer.parseInt(String.valueOf(input.charAt(i+1)));
                sb.append(input.charAt(i));
                continue;
            }

            if (power != 0) {
                power--;
                continue;
            }


            sb.append(input.charAt(i));
        }

        System.out.println(sb);
    }
}
