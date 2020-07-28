import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "exchange": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= array.length) {
                        System.out.println("Invalid index");
                        break;
                    }
                    array = exchange(array, index);
                    break;
                }
                case "max": {
                    command = tokens[1];
                    int index = -1;
                    if ("even".equals(command)) {
                        index = maxEven(array);
                    } else {
                        index = maxOdd(array);
                    }

                    if (index == -1)
                        System.out.println("No matches");
                    else
                        System.out.println(index);
                    break;
                }
                case "min": {
                    command = tokens[1];
                    int index = -1;
                    if ("even".equals(command)) {
                        index = minEven(array);
                    } else {
                        index = minOdd(array);
                    }

                    if (index == -1)
                        System.out.println("No matches");
                    else
                        System.out.println(index);
                    break;
                }
                case "first": {
                    int count = Integer.parseInt(tokens[1]);
                    if (count > array.length || count < 0) {
                        System.out.println("Invalid count");
                        break;
                    }

                    command = tokens[2];
                    int[] result;
                    if ("even".equals(command)) {
                        result = firstEven(array, count);
                    } else {
                        result = firstOdd(array, count);
                    }

                    printArray(result);
                    break;
                }
                case "last": {
                    int count = Integer.parseInt(tokens[1]);
                    if (count > array.length || count < 0) {
                        System.out.println("Invalid count");
                        break;
                    }

                    command = tokens[2];
                    int[] result;
                    if ("even".equals(command)) {
                        result = lastEven(array, count);
                    } else {
                        result = lastOdd(array, count);
                    }

                    printArray(result);
                    break;
                }
            }

            input = scan.nextLine();
        }

        printArray(array);
    }

    private static int[] lastOdd(int[] array, int count) {
        int[] result = new int[0];

        int iterator = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0) {
                result = expandAndAdd(result, array[i]);
                iterator++;
            }

            if (iterator == count)
                break;
        }

        result = reverseArray(result);
        return result;
    }

    private static int[] lastEven(int[] array, int count) {
        int[] result = new int[0];

        int iterator = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                result = expandAndAdd(result, array[i]);
                iterator++;
            }

            if (iterator == count)
                break;
        }

        result = reverseArray(result);
        return result;
    }

    private static int[] firstOdd(int[] array, int count) {
        int[] result = new int[0];

        int iterator = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result = expandAndAdd(result, array[i]);
                iterator++;
            }

            if (iterator == count)
                break;
        }

        return result;
    }

    private static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        int iterator = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[iterator] = array[i];
            iterator++;
        }
        return reversedArray;
    }

    private static int[] firstEven(int[] array, int count) {
        int[] result = new int[0];

        int iterator = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result = expandAndAdd(result, array[i]);
                iterator++;
            }

            if (iterator == count)
                break;
        }

        return result;
    }

    private static int[] expandAndAdd(int[] result, int i) {
        int[] newResult = new int[result.length + 1];

        System.arraycopy(result, 0, newResult, 0, result.length);

        newResult[result.length] = i;
        return newResult;
    }

    private static int minOdd(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] <= minElement) {
                    minElement = array[i];
                    index = i;
                }
            }
        }

        return index;
    }

    private static int minEven(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] <= minElement) {
                    minElement = array[i];
                    index = i;
                }
            }
        }

        return index;
    }

    private static int maxOdd(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] >= maxElement) {
                    maxElement = array[i];
                    index = i;
                }
            }
        }

        return index;
    }

    private static int maxEven(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] >= maxElement) {
                    maxElement = array[i];
                    index = i;
                }
            }
        }

        return index;
    }

    private static int[] exchange(int[] array, int index) {
        int[] resultingArray = new int[array.length];
        
        int iterator = 0;
        for (int i = index + 1; i < array.length; i++) {
            if (iterator == array.length)
                break;
            resultingArray[iterator] = array[i];
            iterator++;
        }
        for (int i = 0; i <= index; i++) {
            if (iterator == array.length)
                break;
            resultingArray[iterator] = array[i];
            iterator++;
        }

        array = resultingArray;
        return array;
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
