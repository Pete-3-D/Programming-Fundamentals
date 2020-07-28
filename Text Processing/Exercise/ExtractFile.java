import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();

        int slashIndex = path.lastIndexOf('\\');
        int pointIndex = path.lastIndexOf('.');

        StringBuilder fileName = new StringBuilder();
        for (int i = slashIndex + 1; i < pointIndex; i++) {
            fileName.append(path.charAt(i));
        }

        StringBuilder fileExtension = new StringBuilder();
        for (int i = pointIndex + 1; i < path.length(); i++) {
            fileExtension.append(path.charAt(i));
        }

        System.out.printf("File name: %s%n", fileName.toString());
        System.out.printf("File extension: %s", fileExtension.toString());
    }
}
