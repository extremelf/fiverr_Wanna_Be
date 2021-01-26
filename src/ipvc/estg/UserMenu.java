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
                System.out.println("Criar um projeto");
                System.out.println("---------");
                System.out.println("Nome do projeto: ");
                String nomePadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Nome do cliente: ");
                String nomeCadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Preço por hora: (nada para preço default)");
                float precoPorHoraadd = scan.nextFloat();

                if(precoPorHoraadd!=0.0f){
                    autenticado.novoProjeto(new projeto(nomePadd,nomeCadd,autenticado.getUserName(),autenticado.getNome(),precoPorHoraadd));
                }
                else{
                    autenticado.novoProjeto(new projeto(nomePadd,nomeCadd,autenticado.getUserName(),autenticado.getNome(),autenticado.getPrecoDefault()));
                }
                break;
            }
            case 3:{
                for(int j = 0;j < autenticado.getProjetos().size();j++){
                    System.out.println(autenticado.getProjetos().get(j).toString());
                }
                System.out.println();
                int alterarProjeto;
                alterarProjeto = inputInt("Selecione Projeto a alterar: ",scan);
                scan.nextLine();

                if(autenticado.getProjetos().get(alterarProjeto)!=null){
                    int alterarProjeto2;
                    alterarProjeto2 = inputInt("-------------------\n1 - Convidar Utilizador\n2 - Remover Projeto\n3 - Remover Convidados\n-------------------",scan);
                    switch (alterarProjeto2){
                        case 1:{
                            if(autenticado.getProjetos().get(alterarProjeto).isAuthor(autenticado.getUserName())) {
                                for(Utilizador utilizadore : utilizadores){
                                    if(utilizadore.toStringReduzido()!=null){
                                        System.out.println(utilizadore.toStringReduzido());
                                    }
                                }
                                scan.nextLine();
                                System.out.println("username do utilizador a convidar:");
                                String convidado = scan.nextLine();

                                for (Utilizador utilizadore : utilizadores) {
                                    if (utilizadore.getUserName().equals(convidado)) {
                                        convites.add(new Convite(autenticado.getUserName(), utilizadore.getUserName(), autenticado.getProjetos().get(alterarProjeto)));
                                        break;
                                    }
                                }
                                System.out.println("Utilizador não encontrado");
                                break;
                            }
                            else{
                                System.out.println("Sem permissão para realizar convites no projeto selecionado");
                                break;
                            }
                        }
                        case 2:{
                            int alterarProjeto3;
                            alterarProjeto3=inputInt("\n1 - Eliminar todas as tarefas\n2 - Desassociar todas as tarefas",scan);
                            scan.nextLine();
                            if(alterarProjeto3==1){
                                for(int xo = 0; xo < autenticado.getProjetos().get(alterarProjeto).getTarefas().size(); xo++){
                                    autenticado.getProjetos().get(alterarProjeto).getTarefas().remove(xo);
                                }
                            }
                            if(alterarProjeto3==2){
                                for(int xi = 0; xi < autenticado.getProjetos().get(alterarProjeto).getTarefas().size(); xi++){
                                    autenticado.getTarefas().add(autenticado.getProjetos().get(alterarProjeto).getTarefas().get(xi));
                                }
                            }
                        }
                        case 3:{
                            for(int xu = 0; xu < autenticado.getProjetos().get(alterarProjeto).getConvidados().size(); xu++){
                                System.out.println("ID Convidado: "+xu);
                                System.out.println(autenticado.getProjetos().get(alterarProjeto).toStringConvidados(xu));
                            }
                            int alterarProjeto4;
                            alterarProjeto4=inputInt("ID de convidado a remover: ",scan);
                            for(Utilizador utilizadore: utilizadores){
                                if(utilizadore.getUserName().equals(autenticado.getProjetos().get(alterarProjeto).getConvidados().get(alterarProjeto4))){
                                    for(int xa = 0; xa < utilizadore.getProjetos().size(); xa++){
                                        if(autenticado.getProjetos().get(alterarProjeto)==utilizadore.getProjetos().get(xa)){
                                            utilizadore.getProjetos().remove(xa);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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
                System.out.println("Selecione a tarefa a alterar: ");
                int alterarTarefa = scan.nextInt();
                scan.nextLine();
                if(autenticado.getTarefas().get(alterarTarefa)!=null){
                    String menuAlterarTarefa = "-------------------\n1 - Apagar Tarefa\n2 - Associar a projeto\n3 - Terminar tarefa\n0 - Sair\n -------------------\n";
                    int alterarTarefa2;
                    alterarTarefa2 = inputInt(menuAlterarTarefa,scan);
                    scan.nextLine();

                    switch(alterarTarefa2){
                        case 1:{
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
                        case 3:{
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
                        System.out.println("Num: "+k);
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
                        autenticado.novoProjeto(convites.get(i).getProjeto());
                        autenticado.getProjetos().get(autenticado.getProjetos().size()-1).novoConvidado(autenticado.getUserName());
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

