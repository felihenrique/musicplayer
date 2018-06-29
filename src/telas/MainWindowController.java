package telas;

import data.Loader;
import data.Music;
import data.PlayList;
import data.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import musicplayer.IMusicPlayerAdapter;
import musicplayer.JavaFxMusicPlayerAdapter;
import utils.FolderUtils;
import utils.JavaFxUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainWindowController {
    IMusicPlayerAdapter player;
    User currentUser;
    PlayList currentPlaylist;
    Loader loader = Loader.getInstance();

    @FXML
    private ListView<PlayList> listPlaylists;
    @FXML
    private ListView<Music> listMusicas;
    @FXML
    private ListView<Music> listReproduzindo;
    @FXML
    private TextField musicSearch;
    @FXML
    private Label labelMusic;
    @FXML
    private Label labelPlaylist;

    public MainWindowController() {
        player = new JavaFxMusicPlayerAdapter();
    }

    @FXML
    public void initialize() {
        currentUser = new User("unnamed");

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
                    setText(item.getName());
                }
            }
        });

        listReproduzindo.setCellFactory(param -> new ListCell<Music>() {
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

        player.setOnMusicChange(m -> labelMusic.setText(m.getName()));
        player.setOnPlaylistChange(p -> labelPlaylist.setText(p.getName()));
    }

    private Window getWindow() {
        return listPlaylists.getScene().getWindow();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setContentText(message);
        alert.show();
    }

    private void updateListMusicas() {
        listMusicas.setItems(FXCollections.observableArrayList(currentUser.getMusics()));
    }

    private void updateListPlaylist() {
        listPlaylists.setItems(FXCollections.observableArrayList(currentUser.getPlayLists()));
    }

    private void updateListPlaying() {
        if(currentPlaylist == null) {
            return;
        }
        listReproduzindo.setItems(FXCollections.observableArrayList(currentPlaylist.getMusics()));
    }

    @FXML
    public void onPlayClick() {
        player.play(listMusicas.selectionModelProperty().get().getSelectedItem());
    }

    @FXML
    public void onAddMusicClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar usuário");
        File f = fileChooser.showOpenDialog(listPlaylists.getScene().getWindow());
        currentUser.addMusic(new Music(f.getPath()));
        updateListMusicas();
    }

    @FXML
    public void onStopClick() {
        player.stop();
    }

    @FXML
    public void onRemoveClick() {
        Music selected = listMusicas.selectionModelProperty().get().getSelectedItem();
        currentUser.removeMusic(selected);
        if(player.getCurrentMusic().equals(selected)) {
            player.stop();
        }
        updateListMusicas();
    }

    @FXML
    public void onAddFolderClick() {
        List<Music> musicsInFolder = FolderUtils.listMp3InFolder(
                JavaFxUtils.folderDialog("Selecione a pasta", getWindow()));
        for(Music m : musicsInFolder) {
            currentUser.addMusic(m);
        }
        updateListMusicas();
    }

    @FXML
    public void onClickPlayPlayList() {
        PlayList selected = listPlaylists.selectionModelProperty().get().getSelectedItem();
        currentPlaylist = selected;
        player.playPlayList(selected);
        updateListPlaying();
    }

    @FXML
    public void onClickProxima() {
        player.nextMusic();
    }

    @FXML
    public void onSearchMusic() {
        String input = musicSearch.getCharacters().toString();
        System.out.println(input);
        if(!input.isEmpty()) {
            List<Music> filtered = currentUser.getMusics()
                                                .stream()
                                                .filter(m -> m.getPath().contains(input))
                                                .collect(Collectors.toList());
            System.out.println(filtered.size());
            listMusicas.setItems(FXCollections.observableArrayList(filtered));
        }
        else {
            listMusicas.setItems(FXCollections.observableArrayList(currentUser.getMusics()));
        }
    }

    @FXML
    public void onClickRemovePlaylist() {
        PlayList selected = listPlaylists.selectionModelProperty().get().getSelectedItem();
        currentUser.removePlayList(selected);
        updateListPlaylist();
    }

    private String showTextInput(String title, String subtitle) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setContentText(subtitle);

        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()) {
            return result.get();
        }
        return "";
    }

    @FXML
    public void onClickNewPlayList() {
        String input = showTextInput("Nome da playlist", "Digite o nome da playlist: ");
        currentUser.newPlaylist(input);
        updateListPlaylist();
    }

    @FXML
    public void onAddToPlaylist() {
        Music musicSelected = listMusicas.selectionModelProperty().get().getSelectedItem();
        if(musicSelected == null) {
            return;
        }
        PlayList playListSelected = JavaFxUtils.playListSelectDialog("Selecione a playlist", currentUser.getPlayLists());
        if(playListSelected != null) {
            playListSelected.addMusic(musicSelected);
            if(currentPlaylist != null && currentPlaylist.equals(playListSelected)) {
                updateListPlaying();
            }
        }
    }

    @FXML
    public void onNewUser() {
        String nome = showTextInput("Novo usuario", "Digite o nome do usuario");
        this.currentUser = new User(nome);
        labelPlaylist.setText("");
        labelPlaylist.setText("");
        updateListPlaying();
        updateListPlaylist();
        updateListMusicas();
        player.stop();
    }

    @FXML
    public void onUserLoginClick() {
        String nome = showTextInput("Novo usuario", "Digite o nome do usuario");
        try {
            String currentDir = System.getProperty("user.dir");
            currentUser = loader.loadUserDef(new File(currentDir + "/" + nome + ".txt"));
            updateListMusicas();
            updateListPlaylist();
        }
        catch (FileNotFoundException e) {
            showAlert("Usuario não encontrado");
            System.out.println("erro");
        }
    }

    @FXML
    public void onSavePerfilClick() {
        try {
            loader.saveUser(currentUser);
        }
        catch (IOException e) {
            showAlert(e.getMessage());
        }
    }
}
