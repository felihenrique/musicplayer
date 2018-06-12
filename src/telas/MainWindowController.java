package telas;

import data.Music;
import data.User;
import javafx.scene.input.MouseEvent;
import musicplayer.MusicPlayer;

public class MainWindowController {
    MusicPlayer player;
    User currentUser;

    public MainWindowController() {
        player = new MusicPlayer();
    }

    public void onClickPlay(MouseEvent mouseEvent) {
        Music m = new Music("/home/felihenrique/teste.mp3");
        player.play(m);
    }

    public void onClickStop(MouseEvent mouseEvent) {
        player.stop();
    }
}
