package ipvc.estg;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import static ipvc.estg.Main.criacaoUtilizadores;
import static ipvc.estg.Main.inputFloat;

public class AdminMenu implements Menu{
    @Override
    public void show(){
        System.out.println("Menu");
        System.out.println(" 1  - Criar utilizador");
        System.out.println(" 2  - Listar utilizadores");
        System.out.println(" 3  - Apagar utilizador");

        System.out.println(" 0  - LOGOUT");
    }



    @Override
    public Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores,ArrayList<Convite> convites) throws IOException, DataFormatException {
        Scanner scan = new Scanner(System.in);
        boolean sucesso=false;
        int i=1;
        switch(op){
            case 0:{
                autenticado = null;
                System.out.println("Logout com sucesso");
                break;
            }
            case 1:{

                System.out.println("Criar um utilizador");
                criacaoUtilizadores(scan,utilizadores);


                break;
            }
            case 2:{
                for (Utilizador utilizadore : utilizadores) {
                    System.out.println(utilizadore.toString());
                }
                break;
            }
            case 3:{
                System.out.println("Introduza o username do utilizador a remover:");
                String user = scan.nextLine();

                for(int k = 0; k < utilizadores.size(); k++){
                    if(utilizadores.get(k).correctUsername(user)){
                        utilizadores.remove(k);
                        System.out.println("Utilizador removido com sucesso");
                    } else {
                        System.out.println("Utilizador não existente");
                    }
                }
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
