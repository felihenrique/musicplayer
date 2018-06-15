package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayList {
    protected String name;
    protected List<Music> musics;

    public PlayList(String name) {
        this.name = name;
        this.musics = new ArrayList<>();
    }

    public void addMusic(Music music) {
        this.musics.add(music);
    }

    public void removeMusic(Music music) {
        this.musics.remove(music);
    }

    public List<Music> getMusics() {
        return musics;
    }

    public String getName() {
        return name;
    }
}
