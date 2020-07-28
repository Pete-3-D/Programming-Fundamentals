import java.util.*;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] arrays = input.split("\\|");
        List<String> result = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] currArray = arrays[i].split("\\s+");
            for (String s : currArray) {
                if (!"".equals(s))
                    result.add(s);
            }
        }

        printList(result);
    }

    private static void printList(List<String> result) {
        for (String element : result)
            System.out.print(element + " ");
    }
}
