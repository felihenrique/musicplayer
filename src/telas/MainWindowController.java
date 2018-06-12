package telas;

import data.Music;
import data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import musicplayer.MusicPlayer;

public class MainWindowController {
    MusicPlayer player;
    User currentUser;
    @FXML
    private ListView<String> listPlaylists;
    @FXML
    private ListView<String> listMusicas;

    private ObservableList items = FXCollections.observableArrayList("aaa", "saasa", "sasas");

    public MainWindowController() {
        player = new MusicPlayer();
    }

    public void onPauseCLick(MouseEvent mouseEvent) {
        listMusicas.setItems(items);
    }
}
