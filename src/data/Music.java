package data;

import java.io.File;
import java.util.UUID;

public class Music {
    protected String path;
    protected String name;
    protected String genre;
    protected String artist;

    public Music(String path, String name, String genre, String artist) {
        this.path = path;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
    }

    public Music(String path) {
        this.path = path;
    }

    public String getPath() { return path; }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Music music2 = (Music)obj;
            return music2.path.equals(this.path);
        }
        catch (Exception e) {
            return false;
        }
    }
}
