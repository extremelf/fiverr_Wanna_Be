package ipvc.estg;

import jdk.jshell.execution.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int op = 0;
        int j = 1;

        String loginUser;
        String password;
        Scanner scan = new Scanner(System.in);

        ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
        Utilizador autenticado = null;

        boolean res = false;

        //Agora tenho um problema de no restart do login ele assume as inputs como "" e tem de se introduzir algo ou só enter para depois sim fazer login corretamente
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
                j=autenticado.getMenu().choose(op,autenticado,utilizadores);
                if(j==0){
                    autenticado=null;
                }
            }while(j == 1);
        }while(true);
    }
}