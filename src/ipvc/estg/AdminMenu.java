package ipvc.estg;

import java.util.Scanner;

public class AdminMenu implements Menu{
    @Override
    public void show(){
        System.out.println("Menu");
        System.out.println(" 1  - Criar utilizador");
        System.out.println(" 2  - Listar utilizador");
        System.out.println(" 3  - Selecionar utilizador");
        System.out.println(" 4  - Apagar utilizador");
        System.out.println(" 5  - Criar UserManager");
        System.out.println(" 6  - Listar UserManagers");
        System.out.println(" 7  - Selecionar UserManager");
        System.out.println(" 8  - Apagar UserManager");
        System.out.println(" 9  - Listas todas as tarefas");
        System.out.println(" 10 - Listar todos os projetos");
        System.out.println(" 11 - LOGOUT");
    }
}
