package ipvc.estg;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * Interface usada para os menus existentes no codigo, com estes metodos.
 * void show(); - mostrar opçoes
 * Utilizador choose(); - Interpreta as opçoes escolhidas pelo user
 * */
public interface Menu {
    void show();
    Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores,ArrayList<Convite> convites) throws IOException, DataFormatException, Exception;
}
