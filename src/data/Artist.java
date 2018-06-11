package data;

import java.util.List;
import java.util.UUID;

public class Artist {
    protected String name;
    protected List<Music> musics;

    protected UUID id;
    protected List<UUID> musicsIds;

    public String getName() {
        return name;
    }

    public List<Music> getMusics() {
        return musics;
    }

}
