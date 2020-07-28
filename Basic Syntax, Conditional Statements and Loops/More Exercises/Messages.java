import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        input = scan.nextLine();
        int iterations = Integer.parseInt(input);

        for (int i = 0; i < iterations; i++) {
            input = scan.nextLine();
            int number = Integer.parseInt(input);

            if (number == 0) {
                System.out.print(" ");
                continue;
            };

            //Find the number of digits the number has “e.g. 222  3 digits”
            int nDigits = input.length();

            //Find the main digit of the number “e.g.  222  2”
            int mainDigit = number % 10;

            //Find the offset of the number. To do that, you can use the formula: (main digit - 2) * 3
            int offSet = (mainDigit - 2) * 3;

            //If the main digit is 7 or 9, we need to add 1 to the offset, since the digits 7 and 9 have 4 letters each
            if (mainDigit == 8 || mainDigit == 9) {
                offSet++;
            }

            //Finally, find the letter index (a  0, c  2, etc.). To do that, we can use the following formula: (offset + digit length - 1).
            int letterIndex = (offSet + nDigits - 1);

            //After we’ve found the letter index, we can just add that to the ASCII code of the lowercase letter “a” (97)
            letterIndex = letterIndex + 97;
            char currentLetter = (char) letterIndex;

            System.out.print(currentLetter);
        }
    }
}
