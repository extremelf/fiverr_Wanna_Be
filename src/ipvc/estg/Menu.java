package ipvc.estg;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public interface Menu {
    void show();
    Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores,ArrayList<Convite> convites) throws IOException, DataFormatException, Exception;
}
