import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());

        repeatString(str, num);
    }

    private static void repeatString(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(str);
        }
    }
}
