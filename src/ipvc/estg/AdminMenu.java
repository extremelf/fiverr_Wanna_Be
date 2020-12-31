package ipvc.estg;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu implements Menu{
    @Override
    public void show(){
        System.out.println("Menu");
        System.out.println(" 1  - Criar utilizador");
        System.out.println(" 2  - Listar utilizadores");
        System.out.println(" 3  - Selecionar utilizador");
        System.out.println(" 4  - Apagar utilizador");
        System.out.println(" 5  - Criar UserManager");
        System.out.println(" 6  - Listar UserManagers");
        System.out.println(" 7  - Selecionar UserManager");
        System.out.println(" 8  - Apagar UserManager");
        System.out.println(" 9  - Listas todas as tarefas");
        System.out.println(" 10 - Listar todos os projetos");
        System.out.println(" 0  - LOGOUT");
    }
    @Override
    public int choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores){
        Scanner scan = new Scanner(System.in);
        int i=1;
        switch(op){
            case 0:{
                i=0;
                break;
            }
            case 1:{
                System.out.println("Opção 1");
                break;
            }
            case 2:{
                for(int j = 0; j < utilizadores.size(); j++){
                    System.out.println("Nome:"+utilizadores.get(j).getNome()+" Profissão:"+utilizadores.get(j).getProfissao()+" Contacto:"+utilizadores.get(j).getContacto());
                }
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                System.out.println("Introduza o username do utilizador a remover:");
                String user = scan.nextLine();

                for(int k = 0; k < utilizadores.size(); k++){
                    if(utilizadores.get(k).correctUsername(user)){
                        utilizadores.remove(k);
                    }
                }
                break;
            }
            case 5:{
                break;
            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            case 8:{
                break;
            }
            case 9:{
                break;
            }
            case 10:{
                break;
            }
            case 11:{
                break;
            }
            default:{
                System.out.println("Escolha opção válida");
                break;
            }
        }
        return i;
    }
}
