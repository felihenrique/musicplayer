package telas;

import data.Loader;
import data.Music;
import data.PlayList;
import data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import musicplayer.MusicPlayerAdapter;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class MainWindowController {
    MusicPlayerAdapter player;
    User currentUser;
    Loader loader = Loader.getInstance();

    @FXML
    private ListView<PlayList> listPlaylists;
    @FXML
    private ListView<Music> listMusicas;
    @FXML
    private Button pauseButton;

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

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setContentText(message);
    }

    @FXML
    public void onPauseCLick(MouseEvent mouseEvent) {
        if(pauseButton.getText() == "Resume") {
            pauseButton.setText("Pause");
            player.resume();
        }
        else {
            pauseButton.setText("Resume");
            player.pause();
        }

    }

    @FXML
    public void onUserLoadClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar usuário");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("definição usuário", "*.txt"));
        try {
            currentUser = loader.loadUser(fileChooser.showOpenDialog(listPlaylists.getScene().getWindow()));
            listPlaylists.setItems(FXCollections.observableArrayList(currentUser.getPlayLists()));
        }
        catch (FileNotFoundException e) {
            showAlert("Usuario não encontrado");
        }
    }
}
