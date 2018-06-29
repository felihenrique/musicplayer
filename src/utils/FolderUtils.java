package utils;

import data.Music;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Contém métodos de utilidade relacionado a pastas.
 */
public class FolderUtils {
    /**
     * Lista todas os arquivos mp3 na pasta.
     * @param folder
     * @return
     */
    public static List<Music> listMp3InFolder(File folder) {
        File[] files = folder.listFiles();
        List<Music> musicList = new ArrayList<>();
        for (File f : files) {
            if(f.getName().endsWith(".mp3")) {
                musicList.add(new Music(f.getPath()));
            }
        }
        return musicList;
    }
}
