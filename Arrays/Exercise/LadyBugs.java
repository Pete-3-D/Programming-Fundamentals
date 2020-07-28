import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        String[] positions = input.split(" ");
        int[] field = new int[fieldSize];

        for (String index : positions) {
            int i = Integer.parseInt(index);
            if (i >= 0 && i < fieldSize) {
                field[i] = 1;
            }
        }

        while (true) {
            input = scan.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] reposition = input.split(" ");

            int ladybugIndex = Integer.parseInt(reposition[0]);
            String direction = reposition[1];
            int flyLength = Integer.parseInt(reposition[2]);

            if (ladybugIndex >= 0 && ladybugIndex < fieldSize && field[ladybugIndex] == 1) {
                field[ladybugIndex] = 0;

                if ("right".equals(direction) && flyLength < 0) {
                    direction = "left";
                } else if ("left".equals(direction) && flyLength < 0) {
                    direction = "right";
                }

                if ("right".equals(direction)) {
                    ladybugIndex = ladybugIndex + Math.abs(flyLength);

                    while (ladybugIndex < fieldSize && field[ladybugIndex] == 1) {
                        ladybugIndex = ladybugIndex + Math.abs(flyLength);
                    }

                    if (ladybugIndex < fieldSize) {
                        field[ladybugIndex] = 1;
                    }
                } else {
                    ladybugIndex = ladybugIndex - Math.abs(flyLength);

                    while (ladybugIndex >= 0 && field[ladybugIndex] == 1) {
                        ladybugIndex = ladybugIndex - Math.abs(flyLength);
                    }

                    if (ladybugIndex >= 0) {
                        field[ladybugIndex] = 1;
                    }
                }
            } // end if-block
        } // end while-loop

        for (int i = 0; i < fieldSize; i++) {
            System.out.print(field[i] + " ");
        }
    }
}
