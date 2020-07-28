import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!(firstDeck.isEmpty() || secondDeck.isEmpty())) {
            int index = 0;
            compareCards(firstDeck, secondDeck, firstDeck.get(index), secondDeck.get(index), index);
        }

        if (firstDeck.isEmpty()) {
            System.out.print("Second player wins! ");
            printSum(secondDeck);
        } else {
            System.out.print("First player wins! ");
            printSum(firstDeck);
        }
    }

    private static void printSum(List<Integer> deck) {
        int sum = 0;

        for (int card : deck) {
            sum = sum + card;
        }

        System.out.print("Sum: " + sum);
    }

    private static void compareCards(List<Integer> firstDeck, List<Integer> secondDeck, int firstDeckCard, int secondDeckCard, int index) {
        if (firstDeckCard > secondDeckCard) {
            firstDeck.remove(index);
            secondDeck.remove(index);
            firstDeck.add(firstDeckCard);
            firstDeck.add(secondDeckCard);
        } else if (secondDeckCard > firstDeckCard) {
            secondDeck.remove(index);
            firstDeck.remove(index);
            secondDeck.add(secondDeckCard);
            secondDeck.add(firstDeckCard);
        } else {
            secondDeck.remove(index);
            firstDeck.remove(index);
        }
    }
}
