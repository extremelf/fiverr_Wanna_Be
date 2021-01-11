package ipvc.estg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
        System.out.println(" 9  - Listar convites");
        System.out.println(" 10 - Alterar convidados");
        System.out.println(" 11 - Imprimir relatorio pessoal do mês");
        System.out.println(" 12 - Imprimir relatorio mensal");
        System.out.println(" 0  - LOGOUT");
    }

    @Override
    public Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores,ArrayList<Convite> convites) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy HH:mm");

        Scanner scan = new Scanner(System.in);
        switch(op){
            case 0:{
                autenticado = null;
                System.out.println("Logout com sucesso");
                break;
            }
            case 1:{
                int op1;

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

                System.out.println("Criar uma tarefa ");
                System.out.println("---------");
                System.out.println("Nome: ");
                String nomeadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Descrição: ");
                String descricaoadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Data de inicio: (DD/MM/YYYY HH:mm)");
                String dataInicio = scan.nextLine();

                Date dataAdd = null;
                if(!dataInicio.isBlank()){
                    dataAdd = format.parse(dataInicio);
                }

                //System.out.println("Numero do projeto: ");
               // String projetoNumAdd = scan.nextLine();
                /*

                  PODES ADICIONAR AQUI O STRING FORMAT PARA O USER INSERIR UMA DATA, EU LEMBRO ME DE FALARES MAS NAO SEI COMO SE FAZ

                  System.out.println("---------");
                System.out.println("Contacto: ");
                String contactadd = scan.nextLine();
                */
               // if(projetoNumAdd.isEmpty()){
                    if(dataAdd!=null){
                        autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd, dataAdd));
                        //autenticado.tarefas.add(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd, dataAdd));
                    }
                    else{
                        autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd));
                        //autenticado.tarefas.add(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd));
                    }
               // }
                                //tarefas.add(new tarefas(projetoNumAdd, nomeadd, descricaoadd, new Date(), new Date()));

                break;
            }
            case 5:{
                for(int k = 0;k<autenticado.getTarefas().size();k++){
                    System.out.println(autenticado.getTarefas().get(k).toString());
                }
            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            case 8:{
                /**
                 * Isto deve passar para dentro do submenu de "alterar tarefa" porque senão tem de listar as tarefas e selecionar uma e na parte de "alterar tarefa" ele já o irá fazer
                 */
                for(int k = 0;k<autenticado.getTarefas().size();k++){
                    System.out.println(autenticado.getTarefas().get(k).toString());
                }
                System.out.println("Qual o numero da tarefa a fazer convite");
                int k = scan.nextInt();

                scan.nextLine();

                System.out.println("username do utilizador a convidar:");
                String convidado = scan.nextLine();

                for(Utilizador utilizadore : utilizadores){
                    if(convidado.equals(utilizadore.getUserName()));
                        convites.add(new Convite(autenticado.getUserName(),utilizadore.getUserName(),autenticado.getTarefas().get(k)));
                        //convites.add(new Convite(autenticado.getUserName(),utilizadore.getUserName(),autenticado.tarefas.get(k)));
                }
                break;
            }
            case 9:{
                int i = 0;
                System.out.println("Convites Recebidos:");
                for (Convite convite : convites) {
                    if (convite.getConvidado().equals(autenticado.getUserName())) {
                        System.out.println("---------------");
                        System.out.println(convite.toString());
                        System.out.println("---------------");
                    }
                }
                System.out.println("Deseja aceitar algum convite?");
                String resposta = scan.nextLine();
                if(resposta.equalsIgnoreCase("SIM")){
                    System.out.println("Introduza o numero do convite:");
                    i = scan.nextInt();
                    autenticado.novaTarefa(convites.get(i).getTarefa());
                    convites.remove(i);
                    break;
                }
                else{
                    break;
                }
            }
            case 10:{
                break;
            }
            case 11:{
                break;
            }
            case 12:{
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

