package data;

import java.io.File;
import java.util.UUID;

public class Music {
    private String path;
    private String name;
    private Genre genre;
    private Artist artist;

    private UUID id;
    private UUID artistId;

    public Music(String path, String name, Genre genre, Artist artist) {
        this.path = path;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.id = UUID.randomUUID();
        this.artistId = artist.id;
    }

    public Music(String path) {
        this.path = path;
    }

    public String getPath() { return path; }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Artist getArtist() {
        return artist;
    }
}
