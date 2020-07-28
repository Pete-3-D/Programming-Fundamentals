import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String encrypted = scan.nextLine();

        List<Integer> digits = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();

        extractDigits(encrypted, digits);
        extractCharacters(encrypted, nonNumbers);

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        splitList(digits, takeList, skipList);

        int condition = Math.max(takeList.size(), skipList.size());
        String decrypted = "";
        int position = 0;
        for (int i = 0; i < condition; i++) {
            if (!takeList.isEmpty()) {
                int takeCount = takeList.get(0);
                decrypted = decrypted + takeCharacters(nonNumbers, takeCount, position);
                takeList.remove(0);
                position = position + takeCount;
            }

            if (!skipList.isEmpty()) {
                int skipCount = skipList.get(0);
                position = position + skipCount;
                skipList.remove(0);
            }
        }

        System.out.println(decrypted);
    }

    private static String takeCharacters(List<Character> input, Integer iterations, int position) {
        String result = "";

        for (int i = 0; i < iterations; i++) {
            if (position >= input.size())
                break;
            result = result + input.get(position);
            position++;
        }

        return result;
    }

    private static void splitList(List<Integer> digits, List<Integer> takeList, List<Integer> skipList) {
        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 != 0) {
                skipList.add(digits.get(i));
            } else {
                takeList.add(digits.get(i));
            }

        }
    }

    private static void extractCharacters(String encrypted, List<Character> nonNumbers) {
        for (int i = 0; i < encrypted.length(); i++) {
            if (!Character.isDigit(encrypted.charAt(i))) {
                nonNumbers.add(encrypted.charAt(i));
            }
        }
    }

    private static void extractDigits(String encrypted, List<Integer> digits) {
        for (int i = 0; i < encrypted.length(); i++) {
            if (Character.isDigit(encrypted.charAt(i))) {
                digits.add(Integer.parseInt(encrypted.charAt(i) + ""));
            }
        }
    }
}
