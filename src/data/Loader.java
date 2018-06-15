package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loader {
    private Loader() { }
    private static Loader instance;
    public static Loader getInstance() {
        if(instance == null) {
            instance = new Loader();
        }
        return instance;
    }

    public User loadUser(File file) throws FileNotFoundException {
        FileInputStream str = new FileInputStream(file);
        Scanner scanner = new Scanner(str);
        User u = new User(scanner.nextLine());
        String line;
        String[] musicas = {};
        Map<String, String[]> playLists = new HashMap<>();
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if(line.equals("musicas")) {
                musicas = scanner.nextLine().split(";");
            }
            else if(line.startsWith("playlist_")) {
                playLists.put(line, scanner.nextLine().split(";"));
            }
        }
        for(String musica : musicas) {
            u.addMusic(new Music(musica));
        }
        for(Map.Entry<String, String[]> entry : playLists.entrySet()) {
            PlayList p = new PlayList(entry.getKey().split("_")[1]);
            for(String musica : entry.getValue()) {
                p.addMusic(new Music(musica));
            }
            u.playLists.add(p);
        }
        return u;
    }
}
