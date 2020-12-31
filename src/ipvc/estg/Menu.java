package ipvc.estg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public interface Menu {
    /**
     * Isto é uma interface criada por ti que apenas tem a função de print dos menus?
     *
     */
    void show();
    int choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores) throws IOException, DataFormatException;
}
