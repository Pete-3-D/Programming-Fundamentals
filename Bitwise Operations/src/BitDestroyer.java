import java.util.Scanner;
import java.util.Set;

public class BitDestroyer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int p = Integer.parseInt(scan.nextLine());
        int mask = 1 << p;
        mask = ~mask;
        int newNumber = n & mask;

        System.out.println(newNumber);
        /*
        c.	Use & mask operator expression to set the value of a number to 0.
        By using the following formulae (n & mask) you copy all the bits of the number and you set the bit at position p to 0;
        d.	Save the result in newNumber;
        4.	Print the result on the console.*/

    }
}
