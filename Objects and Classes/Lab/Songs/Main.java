import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];

            Song newSong = new Song();

            newSong.setTypeList(typeList);
            newSong.setName(name);
            newSong.setTime(time);

            songs.add(newSong);
        }

        String input = scan.nextLine();

        for (Song song : songs) {
            String name = song.getSong(input);

            if (name != null)
                System.out.println(song.getSong(input));
        }

    }
}
