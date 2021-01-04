package ipvc.estg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import jdk.jshell.execution.Util;

public class Main {

    public static void main(String[] args)throws IOException, DataFormatException {
        /*int op;

        String loginUser;
        String password;
        Scanner scan = new Scanner(System.in);

        ArrayList<Utilizador> utilizadores = new ArrayList<>();
        Utilizador autenticado;
        autenticado = null;


        boolean res = false;

        //diz o que achas desta forma de organizar a main, o programa em si fica a funcionar nos "User/AdminMenu.java, a main ficaria assim só

        //Criar o admin por defeito
        // Não estou a conseguir verificar se está realmente vazio porque pode ter null e não deixa ver se está empty
        // if (utilizadores.isEmpty()) {
        utilizadores.add(new Admin("admin", "admin", "admin", "admin", "admin"));
        utilizadores.add(new Admin("admin1", "admin1", "admin1", "admin", "admin"));
        utilizadores.add(new Utilizador("user", "user", "user", "user", "user"));
        // }
        do {
            do{
                System.out.println("Faça login com as suas credenciais");

                System.out.println("Username:");
                loginUser = scan.nextLine();

                System.out.println("Password:");
                password = scan.nextLine();

                for (int i = 0; i < utilizadores.size(); i++) {
                    res = utilizadores.get(i).Login(loginUser, password);
                    if (res) {
                        autenticado = utilizadores.get(i);
                        System.out.println("Sucesso");
                        break;
                    }
                }
            }while(!res);

            do {
                autenticado.getMenu().show();
                op = scan.nextInt();
                autenticado=autenticado.getMenu().choose(op,autenticado,utilizadores);
                scan.nextLine();
            }while(autenticado != null);
        }while(true);*/

        new LoginInterface();
    }
}