import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String result = "";

        switch (input) {
            case "England":
            case "USA":
                result = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                result = "Spanish";
                break;
            default:
                result = "unknown";
                break;
        }
        System.out.println(result);
    }
}
