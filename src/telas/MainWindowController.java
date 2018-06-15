package telas;

import data.Loader;
import data.Music;
import data.PlayList;
import data.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import musicplayer.MusicPlayerAdapter;

import java.awt.event.ActionEvent;

public class MainWindowController {
    MusicPlayerAdapter player;
    User currentUser;
    Loader loader = Loader.getInstance();

    @FXML
    private ListView<PlayList> listPlaylists;
    @FXML
    private ListView<Music> listMusicas;

    public MainWindowController() {
        player = new MusicPlayerAdapter();
    }

    @FXML
    public void initialize() {
        listPlaylists.setCellFactory(param -> new ListCell<PlayList>() {
            @Override
            protected void updateItem(PlayList item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                }
                else {
                    setText(item.getName());
                }
            }
        });

        listMusicas.setCellFactory(param -> new ListCell<Music>() {
            @Override
            protected void updateItem(Music item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item == null) {
                    setText(null);
                }
                else {
                    setText(item.getPath());
                }
            }
        });
    }

    @FXML
    public void onPauseCLick(MouseEvent mouseEvent) {

    }

    @FXML
    public void onUserLoadClick() {

    }
}
