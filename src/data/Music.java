package data;

import java.io.File;

/**
 * Classe que representa uma música.
 */
public class Music {
    private File file;

    /**
     * Instancia uma nova música.
     * @param path Caminho da música.
     */
    public Music(String path) {
        this.file = new File(path);
    }

    /**
     * Retorna o caminho da musica.
     * @return
     */
    public String getPath() { return file.getPath(); }

    /**
     * Retorna o nome da música.
     * @return
     */
    public String getName() {
        return file.getName();
    }

    /**
     * Método de comparação para == usado para indicar se uma música é igual a outra.
     * @param obj Música a ser comparada.
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        try {
            Music other = (Music)obj;
            return other.getPath().equals(file.getPath());
        }
        catch (Exception e) {
            return false;
        }
    }
}
