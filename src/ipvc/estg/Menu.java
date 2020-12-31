package ipvc.estg;

import java.util.ArrayList;

public interface Menu {
    void show();
    int choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores);
}
