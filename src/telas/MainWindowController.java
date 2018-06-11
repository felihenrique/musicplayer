package telas;

import data.Music;
import javafx.scene.input.MouseEvent;
import musicplayer.MusicPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MainWindowController {
    MusicPlayer player;

    public MainWindowController() {
        player = new MusicPlayer();
    }

    public void onClickPlay(MouseEvent mouseEvent) {
        Music m = new Music("/home/datacom/teste.mp3");
        player.play(m);
    }

    public void onClickStop(MouseEvent mouseEvent) {
        player.stop();
    }
}
