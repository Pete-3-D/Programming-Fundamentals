// fuck this problem in particular.
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        int size = Integer.parseInt(scan.nextLine());

        int sequenceRow = 0;
        int bestSequenceSum = 0;
        int bestSubsequenceLength = 0;
        int bestSubsequenceIndex = 0;
        int bestRow = 0;
        String[] bestSequence = new String[size];

        while (true) {
            sequenceRow++;
            input = scan.nextLine();

            if ("Clone them!".equals(input)) {
                break;
            }

            String[] currentSequence = input.split("!+");

            int subsequenceLength = 0;
            int subsequenceIndex = -1;
            int currentBestLength = 0;
            int currentBestIndex = 0;

            for (int i = 0; i < size; i++) { // start for
                subsequenceLength = 0;
                for (int j = i; j < size; j++) {
                    if ("1".equals(currentSequence[j])) {
                        subsequenceIndex = i;
                        subsequenceLength++;

                        if (subsequenceLength > currentBestLength) {
                            currentBestLength = subsequenceLength;
                            currentBestIndex = subsequenceIndex;
                        }
                    } else {
                        break;
                    } // end if-else block
                } //end inner for loop
            } //end for loop


            if (currentBestLength > bestSubsequenceLength) {
                bestRow = sequenceRow;
                bestSubsequenceLength = currentBestLength;
                bestSubsequenceIndex = currentBestIndex;
                bestSequenceSum = sumAll(currentSequence);
                bestSequence = currentSequence;
            } else if (currentBestLength == bestSubsequenceLength) {
                if (currentBestIndex < bestSubsequenceIndex) {
                    bestRow = sequenceRow;
                    bestSubsequenceLength = currentBestLength;
                    bestSubsequenceIndex = currentBestIndex;
                    bestSequenceSum = sumAll(currentSequence);
                    bestSequence = currentSequence;
                } else if (currentBestIndex == bestSubsequenceIndex) {
                    if (bestSequenceSum < sumAll(currentSequence)) {
                        bestRow = sequenceRow;
                        bestSubsequenceLength = currentBestLength;
                        bestSubsequenceIndex = currentBestIndex;
                        bestSequenceSum = sumAll(currentSequence);
                        bestSequence = currentSequence;
                    }
                }
            }
        } //end while loop


        if (bestRow == 0) {
            bestRow = 1;
            for (int i = 0; i < size; i++) {
                bestSequence[i] = "0";
            }
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestRow, bestSequenceSum);
        System.out.println(String.join(" ", bestSequence));
    }

    public static int sumAll(String[] sequence) {
        int sum = 0;

        for (int i = 0; i < sequence.length; i++) {
            if ("1".equals(sequence[i]))
                sum++;
        }

        return sum;
    }
}
