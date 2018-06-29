package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o usuário do player.
 * Aqui é armazenado todas as suas playlists e músicas.
 */
public class User {
    private String name;
    List<PlayList> playLists;
    private List<Music> musics;

    /**
     * Instancia um novo usuário.
     * @param name Nome do usuário.
     */
    public User(String name) {
        this.name = name;
        this.playLists = new ArrayList<>();
        this.musics = new ArrayList<>();
    }

    /**
     * Retorna o nome do usuário.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Adiciona uma música a lista de músicas do usuário.
     * @param music
     */
    public void addMusic(Music music) {
        if(musics.contains(music)) {
            return;
        }
        this.musics.add(music);
    }

    /**
     * Retorna a lista de músicas do usuário.
     * @return
     */
    public List<Music> getMusics() { return musics; }

    /**
     * Remove uma música da lista de músicas do usuário.
     * @param music
     */
    public void removeMusic(Music music) {
        this.musics.remove(music);
    }

    /**
     * Cria uma nova playlist.
     * @param name Nome da nova playlist.
     */
    public void newPlaylist(String name) {
        this.playLists.add(new PlayList(name));
    }

    /**
     * Retorna a lista de playlists do usuário.
     * @return
     */
    public List<PlayList> getPlayLists() {
        return playLists;
    }

    /**
     * Remove uma playlist da lista de playlists do usuário.
     * @param playList
     */
    public void removePlayList(PlayList playList) {
        this.playLists.remove(playList);
    }
}
