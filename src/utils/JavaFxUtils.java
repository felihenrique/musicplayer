package utils;

import data.PlayList;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Classe que tem métodos para facilitar algumas tarefas.
 */
public class JavaFxUtils {
    /**
     * Mostra um dialogo para selecionar uma pasta.
     * @param title
     * @param window
     * @return
     */
    public static File folderDialog(String title, Window window) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle(title);
        return chooser.showDialog(window);
    }

    /**
     * Mostra um diálogo para selecionar uma playlist
     * @param title
     * @param list
     * @return
     */
    public static PlayList playListSelectDialog(String title, List<PlayList> list) {
        ChoiceDialog<PlayList> dialog = new ChoiceDialog<>(null, list);
        dialog.setTitle(title);
        dialog.setContentText(title);
        Optional<PlayList> result = dialog.showAndWait();
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
