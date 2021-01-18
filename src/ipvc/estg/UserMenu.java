package ipvc.estg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserMenu implements Menu{
    public static int inputInt(String out, Scanner scan){
        System.out.println(out);
        try{
            return scan.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Input errado, introduza um número!");
            scan.next();
            return inputInt(out,scan);
        }
    }

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
    public Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores,ArrayList<Convite> convites) throws Exception {
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
                    autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd, dataAdd));
                }
                else{
                    autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd));
                }
                break;
            }
            case 5:{
                for(int k = 0;k<autenticado.getTarefas().size();k++){
                    System.out.println(autenticado.getTarefas().get(k).toString());
                }
                System.out.println("Selecione a tarefa a alterar:");
                int alterarTarefa = scan.nextInt();
                scan.nextLine();
                if(autenticado.getTarefas().get(alterarTarefa)!=null){
                    String menuAlterarTarefa = "-------------------\n1 - Convidar utilizador\n2 - Apagar Tarefa\n3 - Associar a projeto\n4 - Terminar tarefa\n0 - Sair\n -------------------\n";
                    int alterarTarefa2;
                    alterarTarefa2=inputInt(menuAlterarTarefa,scan);
                    scan.nextLine();

                    switch(alterarTarefa2){
                        case 1:{
                            if(autenticado.getTarefas().get(alterarTarefa).isAuthor(autenticado.getUserName())) {
                                for(Utilizador utilizadore : utilizadores){
                                    if(utilizadore.toStringReduzido()!=null){
                                        System.out.println(utilizadore.toStringReduzido());
                                    }
                                }
                                System.out.println("username do utilizador a convidar:");
                                String convidado = scan.nextLine();

                                for (Utilizador utilizadore : utilizadores) {
                                    if (utilizadore.getUserName().equals(convidado)) {
                                        convites.add(new Convite(autenticado.getUserName(), utilizadore.getUserName(), autenticado.getTarefas().get(alterarTarefa)));
                                        break;
                                    }
                                }
                                System.out.println("Utilizador não encontrado");
                                break;
                            }
                            else{
                                System.out.println("Sem permissão para realizar convites na tarefa selecionada");
                                break;
                            }
                        }
                        case 2:{
                            if(autenticado.getTarefas().get(alterarTarefa).isAuthor(autenticado.getUserName())){
                                int opApagar=0;
                                do{
                                    opApagar=inputInt("Confirmação:\n1 - Apagar\n2 - Cancelar",scan);
                                    switch(opApagar){
                                        case 1:{
                                            autenticado.getTarefas().remove(alterarTarefa);
                                        }
                                        case 2:{
                                            System.out.println("Cancelado com sucesso");
                                        }
                                        default:{
                                            System.out.println("Existem apenas 2 opçoes");
                                        }
                                    }
                                }while(opApagar!=2);
                            }
                            else{
                                System.out.println("Sem permissão para realizar convites na tarefa selecionada");
                            }
                            break;
                        }
                        case 4:{
                            if (autenticado.getTarefas().get(alterarTarefa).getDataHorafim()!=null) {
                                System.out.println("Data de inicio: (DD/MM/YYYY HH:mm)");
                                String dataFim = scan.nextLine();
                                Date dataFimAdd = null;
                                if (!dataFim.isBlank()) {
                                    dataFimAdd = format.parse(dataFim);
                                    autenticado.getTarefas().get(alterarTarefa).terminarTarefa(dataFimAdd);
                                } else {
                                    autenticado.getTarefas().get(alterarTarefa).terminarTarefa();
                                }
                            } else {
                                System.out.println("Tarefa já está terminada");
                            }
                            break;
                        }
                        case 0:{
                            break;
                        }
                    }
                }

            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            case 9:{
                int i = 0;
                int contador = 0;
                System.out.println("Convites Recebidos:");
                for (int k = 0; k<convites.size();k++) {
                    if (autenticado.getUserName().equals(convites.get(k).getConvidado())) {
                        System.out.println("---------------");
                        System.out.println(k);
                        System.out.println(convites.get(k).toString());
                        System.out.println("---------------");
                        contador++;
                    }
                }
                if(contador!=0){
                    System.out.println("Deseja aceitar algum convite?");
                    String resposta = scan.nextLine();
                    if(resposta.equalsIgnoreCase("sim")){
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

