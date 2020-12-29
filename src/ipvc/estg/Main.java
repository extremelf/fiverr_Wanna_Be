package ipvc.estg;

import jdk.jshell.execution.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int op = 0;

        //String admin = "admin";
        String loginUser;
        String password;
        Scanner scan = new Scanner(System.in);
        ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
        Utilizador autenticado = null;
        boolean res = true;
        //Criar o admin por defeito
        // Não estou a conseguir verificar se está realmente vazio porque pode ter null e não deixa ver se está empty
        // if (utilizadores.isEmpty()) {
            utilizadores.add(new Admin("admin","admin","admin","admin","admin"));
        // }

        do {
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
        } while (!res);

        do {


            autenticado.getMenu().show();
            op = scan.nextInt();

            switch (op) {
                case 1:
                    break;
                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                case 0:
                    break;

                default: System.out.println("Opção válida please");
            }

        }while (op!=0);
    }
}