package data;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String name;
    protected List<PlayList> playLists;
    protected List<Music> musics;

    public User(String name) {
        this.name = name;
        this.playLists = new ArrayList<>();
        this.musics = new ArrayList<>();
    }

    public void addMusic(Music music) {
        this.musics.add(music);
    }

    public void removeMusic(Music music) {
        this.musics.add(music);
    }

    public void newPlaylist(String name) {
        this.playLists.add(new PlayList(name));
    }

    public void removePlayList(PlayList playList) {
        this.playLists.remove(playList);
    }
}
