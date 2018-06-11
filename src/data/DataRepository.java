package data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataRepository {
    private static Map<UUID, User> users = new HashMap<>();
    private static Map<UUID, Genre> genres = new HashMap<>();
    private static Map<UUID, Music> musics = new HashMap<>();
    private static Map<UUID, Artist> artists = new HashMap<>();
    private static Map<UUID, PlayList> playLists = new HashMap<>();

    public void load(String path) {

    }
}

