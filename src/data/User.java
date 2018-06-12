package data;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializable;
import com.esotericsoftware.jsonbeans.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class User implements JsonSerializable {
    protected String name;
    protected Map<String, PlayList> playLists;
    protected Map<String, Music> musics;

    public User(String name) {
        this.name = name;
        this.playLists = new HashMap<>();
        this.musics = new HashMap<>();
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        name = jsonValue.getString("name");
        playLists = new HashMap<>();
        musics = new HashMap<>();
        jsonValue.get("musics").forEach(data -> {
            Music music = json.fromJson(Music.class, data.asString());
            musics.put(music.path, music);
        });
        jsonValue.get("playlists").forEach(data -> {
            PlayList playList = json.fromJson(PlayList.class, data.asString());
            playLists.put(playList.name, playList);
        });
    }

    @Override
    public void write(Json json) {
        json.writeField(name, "name");
        json.writeArrayStart("musics");
        musics.forEach( (String s, Music music) -> json.writeValue(music.path));
        json.writeArrayEnd();
        json.writeArrayStart("playlists");
        playLists.forEach((String s, PlayList playList) -> json.writeValue(playList));
        json.writeArrayEnd();
    }
}
