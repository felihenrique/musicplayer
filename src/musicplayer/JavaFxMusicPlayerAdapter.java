package musicplayer;

import data.Music;
import data.PlayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.function.Consumer;

public class JavaFxMusicPlayerAdapter implements IMusicPlayerAdapter {
    private MediaPlayer player;
    private Music currentMusic;
    private PlayList playList;
    private Media media;
    private Consumer<Music> onMusicChange;
    private Consumer<PlayList> onPlaylistChange;

    public void play() {
        play(currentMusic);
    }

    public void play(Music music) {
        if(music == null) {
            return;
        }
        stop();
        media = new Media("file://" + music.getPath());
        player = new MediaPlayer(media);
        player.setOnEndOfMedia(this::nextMusic);
        currentMusic = music;
        player.play();
        onMusicChange.accept(music);
    }

    public Music getCurrentMusic() {
        return currentMusic;
    }

    public void nextMusic() {
        currentMusic = playList.nextMusic();
        play();
    }

    public void playPlayList(PlayList playList) {
        this.playList = playList;
        currentMusic = playList.nextMusic();
        play(currentMusic);
        onPlaylistChange.accept(playList);
    }

    public void stop() {
        if(player == null) {
            return;
        }
        player.stop();
    }

    @Override
    public void setOnMusicChange(Consumer<Music> consumer) {
        this.onMusicChange = consumer;
    }

    @Override
    public void setOnPlaylistChange(Consumer<PlayList> consumer) {
        this.onPlaylistChange = consumer;
    }
}
