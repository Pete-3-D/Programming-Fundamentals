import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();

        switch (type) {
            case "int":
                int firstInt = Integer.parseInt(scan.nextLine());
                int secondInt = Integer.parseInt(scan.nextLine());
                int resultInt = getMax(firstInt, secondInt);
                System.out.println(resultInt);
                break;
            case "char":
                char firstChar = scan.nextLine().charAt(0);
                char secondChar = scan.nextLine().charAt(0);
                char resultChar = getMax(firstChar, secondChar);
                System.out.println(resultChar);
                break;
            case "string":
                String firstString = scan.nextLine();
                String secondString = scan.nextLine();
                String result = "";
                if (getMax(firstString, secondString) == 1) {
                    System.out.println(firstString);
                } else {
                    System.out.println(secondString);
                }

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private static int getMax(int firstInt, int secondInt) {
        return Math.max(firstInt, secondInt);
    }

    private static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar)
            return firstChar;
        else
            return secondChar;
    }

    private static int getMax(String firstString, String secondString) {
        return firstString.compareTo(secondString);
    }
}
