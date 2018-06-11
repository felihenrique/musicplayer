package data;

import java.util.List;
import java.util.UUID;

public class PlayList {
    protected String name;
    protected List<Music> musics;
    protected User user;

    protected List<UUID> musicsIds;
    protected UUID userId;
}
