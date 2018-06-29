package data;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe responsável por carregar e salvar o perfil do usuário no disco
 */
public class Loader {
    private Loader() { }
    private static Loader instance;
    public static Loader getInstance() {
        if(instance == null) {
            instance = new Loader();
        }
        return instance;
    }

    /**
     * Carrega um usuário
     * @param file Objeto file represetando o caminho contendo o arquivo do usuário.
     * @return Usuário carregado
     * @throws FileNotFoundException
     */
    public User loadUserDef(File file) throws FileNotFoundException {
        FileInputStream str = new FileInputStream(file);
        Scanner scanner = new Scanner(str);
        User u = new User(scanner.nextLine());
        String line;
        String[] musicas = {};
        Map<String, String[]> playLists = new HashMap<>();
        while (scanner.hasNextLine()) {
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

    /**
     * Salva um usuário no disco. O nome do arquivo é o mesmo do nome do usuário.
     * @param user Usuário a ser salvo.
     * @throws IOException
     */
    public void saveUser(User user) throws IOException {
        String currentDir = System.getProperty("user.dir");
        String path = currentDir + "/" + user.getName() + ".txt";
        FileWriter writer = new FileWriter(path);
        writer.write(user.getName() + "\n");
        if(!user.getMusics().isEmpty()) {
            writer.write("musicas" + "\n");
            for(Music m : user.getMusics()) {
                writer.write(m.getPath() + ";");
            }
            writer.write("\n");
        }
        if(!user.getPlayLists().isEmpty()) {
            for(PlayList p : user.getPlayLists()) {
                writer.write("playlist_" + p.getName() + "\n");
                for (Music m : p.getMusics()) {
                    writer.write(m.getPath() + ";");
                }
                writer.write("\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
