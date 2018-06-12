package musicplayer;

import data.Music;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.util.Duration;

public class MusicPlayer {
    MediaPlayer player;
    Music currentMusic;
    Media media;

    public void play(Music music) {
        if(music.equals(currentMusic)) {
            resume();
            return;
        }
        stop();
        media = new Media("file://" + music.getPath());
        player = new MediaPlayer(media);
        currentMusic = music;
        player.play();
    }

    public void stop() {
        if(player == null) {
            return;
        }
        player.stop();
    }

    public void pause() {
        player.pause();
    }

    public void resume() {
        player.play();
    }

    public void advance(long time) {
        resume();
        Duration total = player.getCurrentTime().add(Duration.millis(time));
        player.seek(total);
    }
}
