package ipvc.estg;

import java.util.ArrayList;

public interface Menu {
    /**
     * Isto é uma interface criada por ti que apenas tem a função de print dos menus?
     *
     */
    void show();
    int choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores);
}
