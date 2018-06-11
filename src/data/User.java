package data;

import java.util.List;
import java.util.UUID;

public class User {
    protected String name;
    protected List<PlayList> playLists;

    protected UUID id;
    protected List<UUID> playListsIds;
}
