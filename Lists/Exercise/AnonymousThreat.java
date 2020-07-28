import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inputList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!"3:1".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            if ("merge".equals(command)) {
                int startIndex = Integer.parseInt(tokens[1]);
                startIndex = evaluateIndex(startIndex, inputList);
                int endIndex = Integer.parseInt(tokens[2]);
                endIndex = evaluateIndex(endIndex, inputList);
                mergeElements(inputList, startIndex, endIndex);
            } else {
                int index = Integer.parseInt(tokens[1]);
                int partitionCount = Integer.parseInt(tokens[2]);
                divideElement(inputList, index, partitionCount);
            }

            input = scan.nextLine();
        }

        printList(inputList);
    }

    private static void divideElement(List<String> inputList, int index, int partitionCount) {
        String s = inputList.get(index);
        inputList.remove(index);

        String[] partition = new String[partitionCount];
        int partitionSize = s.length() / partitionCount;
        for (int i = 0; i < partitionCount; i++) {
            partition[i] = "";
            if (i == partitionCount - 1 && s.length() % partitionCount != 0) {
                partitionSize = s.length();
            }
            for (int j = 0; j < partitionSize; j++) {
                if (j == s.length())
                    break;
                partition[i] = partition[i] + s.charAt(j);
            }
            inputList.add(index, partition[i]);
            index++;
            s = shrinkString(s, partitionSize);
        }
    }

    private static String shrinkString(String s, int index) {
        String newString = "";

        for (int i = index; i < s.length(); i++) {
            newString = newString + s.charAt(i);
        }

        return newString;
    }

    private static int evaluateIndex(int index, List<String> inputList) {
        if (index < 0)
            return 0;
        else if (index >= inputList.size())
            return inputList.size() - 1;

        return index;
    }

    private static void printList(List<String> inputList) {
        for (String element : inputList) {
            System.out.print(element + " ");
        }
    }

    private static void mergeElements(List<String> inputList, int startIndex, int endIndex) {
        String merged = "";
        int count = endIndex - startIndex;
        int index = 0;

        while (index <= count) {
            merged = merged + inputList.get(startIndex);
            inputList.remove(startIndex);
            index++;
        }

        inputList.add(startIndex, merged);
    }
}
