package ipvc.estg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int op=0;

        //String admin = "admin";
        String loginUser;
        String password;
	Scanner scanlogin = new Scanner(System.in);

	do {


        System.out.println("Faça login com as suas credenciais");


        System.out.println("Username:");
        loginUser = scanlogin.nextLine();

        System.out.println("Password:");
        password = scanlogin.nextLine();

    //Scanner scanpass = new Scanner(System.in);

        switch (op)

    } while ()



        Scanner scanop = new Scanner(System.in);
    do {


        System.out.println("Menu");
        System.out.println(" 1 - Criar utilizador");
        System.out.println(" 2 - Listar utilizador");
        System.out.println(" 3 - Selecionar utilizador");
        System.out.println(" 4 - Apagar utilizador");
        System.out.println(" 5 - Criar UserManager");
        System.out.println(" 6 - Listar UserManagers");
        System.out.println(" 7 - Selecionar UserManager");
        System.out.println(" 8 - Apagar UserManager");
        System.out.println(" 9 - Listas todas as tarefas");
        System.out.println(" 10 - Listar todos os projetos");
        System.out.println(" 11 - LOGOUT");

        op = scanop.nextInt();

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

    }   while (op!=0);





	System.out.print("aksjdakj");
    }
}
