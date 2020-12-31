package ipvc.estg;

import java.util.ArrayList;

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
    public int choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores){
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
        return i;
    }
}

