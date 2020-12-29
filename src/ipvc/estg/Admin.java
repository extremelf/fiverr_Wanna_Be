package ipvc.estg;

public class Admin extends Utilizador {
    public Admin(String userName, String nome, String password, String profissao, String contacto) {
        super(userName, nome, password, profissao, contacto);
    }

    @Override
    public Menu getMenu(){
        return new AdminMenu();
    }
}