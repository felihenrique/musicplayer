package musicplayer;

import data.Music;
import data.PlayList;

import java.util.function.Consumer;

/**
 * Interface que representa uma reprodutor de música. Implementando essa interface é possível gerar
 * novas maneiras de reproduzir músicas.
 */
public interface IMusicPlayerAdapter {
    /**
     * Reproduz uma música
     * @param music
     */
    void play(Music music);

    /**
     * Avança para a próxima música na playlist atual.
     */
    void nextMusic();

    /**
     * Reproduz uma playlist.
     * @param playList
     */
    void playPlayList(PlayList playList);

    /**
     * Para a reprodução atual.
     */
    void stop();

    /**
     * Retorna a música que está sendo reproduzida atualmente.
     * @return
     */
    Music getCurrentMusic();

    /**
     * Registra um callback para ser chamado quando a música reproduzida muda.
     * @param consumer
     */
    void setOnMusicChange(Consumer<Music> consumer);

    /**
     * Registra um callback para ser chamado quando a playlist reproduzida muda.
     * @param consumer
     */
    void setOnPlaylistChange(Consumer<PlayList> consumer);
}
