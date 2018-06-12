package data;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializable;
import com.esotericsoftware.jsonbeans.JsonValue;

import java.util.List;

public class PlayList implements JsonSerializable {
    protected String name;
    protected List<Music> musics;

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonValue) {

    }
}
