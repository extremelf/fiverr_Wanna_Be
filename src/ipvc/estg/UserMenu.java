package ipvc.estg;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu implements Menu{
    @Override
    public void show(){
        System.out.println("Menu");
        System.out.println(" 1  - Editar dados");
        System.out.println(" 2  - Criar projeto");
        System.out.println(" 3  - Alterar projeto");
        System.out.println(" 4  - Criar tarefa");
        System.out.println(" 5  - Alterar tarefa");
        System.out.println(" 6  - Remover tarefas");
        System.out.println(" 7  - Listar tarefas por intervalo");
        System.out.println(" 8  - Convidar utilizador");
        System.out.println(" 9  - Alterar convidados");
        System.out.println(" 10 - Imprimir relatorio pessoal do mês");
        System.out.println(" 11 - Imprimir relatorio mensal");
        System.out.println(" 0  - LOGOUT");
    }
    @Override
    public Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores){
        int i=1;
        switch(op){
            case 0:{
                autenticado = null;
                System.out.println("Logout com sucesso");
                break;
            }
            case 1:{
                Scanner scan = new Scanner(System.in);
                int op1=0;

                System.out.println("Dado a alterar:");
                System.out.println("1 - Username");
                System.out.println("2 - Nome");
                System.out.println("3 - Password");
                System.out.println("4 - Profissão");
                System.out.println("5 - Contacto");
                System.out.println("0 - Sair");
                op1 = scan.nextInt();

                if(op1 == 0){
                    break;
                }
                autenticado.AlterarDados(op1);
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
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
        return autenticado;
    }
}

