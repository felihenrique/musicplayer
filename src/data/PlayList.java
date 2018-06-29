package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma playlist.
 */
public class PlayList {
    protected String name;
    protected List<Music> musics;
    protected int currentMusicPosition = 0;

    /**
     * Instancia uma nova playlist.
     * @param name
     */
    public PlayList(String name) {
        this.name = name;
        this.musics = new ArrayList<>();
    }

    /**
     * Adiciona uma música a playlist.
     * @param music
     */
    public void addMusic(Music music) {
        this.musics.add(music);
    }

    /**
     * Remove uma música da playlist.
     * @param music
     */
    public void removeMusic(Music music) {
        this.musics.remove(music);
    }

    /**
     * Retorna a lista de músicas da playlist.
     * @return
     */
    public List<Music> getMusics() {
        return musics;
    }

    /**
     * Retorna o nome da playlist
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Avança para a próxima música da playlist
     * @return A próxima música da playlist.
     */
    public Music nextMusic() {
        if(musics.isEmpty()) {
            return null;
        }
        if(currentMusicPosition == musics.size()) {
            currentMusicPosition = 0;
        }
        Music m = musics.get(currentMusicPosition);
        currentMusicPosition++;
        return m;
    }

    /**
     * Nome da playlist.
     * @return
     */
    @Override
    public String toString() {
        return name;
    }
}
