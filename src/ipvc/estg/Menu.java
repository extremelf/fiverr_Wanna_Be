package ipvc.estg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public interface Menu {
    void show();
    Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores) throws DataFormatException, IOException;
}
