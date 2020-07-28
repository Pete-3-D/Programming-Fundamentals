import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(scan.nextLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        int sum = 0;

        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(scan.nextLine());
            int removedElement = 0;

            if (index < 0) {
                removedElement = pokemons.get(0);
                pokemons.remove(0);
                pokemons.add(0, pokemons.get(pokemons.size() - 1));
            } else if (index >= pokemons.size()) {
                removedElement = pokemons.get(pokemons.size() - 1);
                pokemons.remove(pokemons.size() - 1);
                pokemons.add(pokemons.size(), pokemons.get(0));
            } else {
                removedElement = pokemons.get(index);
                pokemons.remove(index);
            }

            sum = sum + removedElement;
            adjustList(pokemons, removedElement);
        }

        System.out.println(sum);
    }

    private static void adjustList(List<Integer> pokemons, int removedElement) {
        for (int i = 0; i < pokemons.size(); i++) {
            int currElement = pokemons.get(i);

            if (removedElement < currElement) {
                pokemons.set(i, currElement - removedElement);
            } else {
                pokemons.set(i, currElement + removedElement);
            }
        }
    }
}
