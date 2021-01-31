package ipvc.estg;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserMenu implements Menu{

    /**
     * metodo usado para verificar se o numero é inteiro
     */

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


    public void eliminaProjetoConvidados(Utilizador autenticado, ArrayList<Utilizador> utilizadores, int posicao){
        for(int xx = 0; xx < autenticado.getProjetos().get(posicao).getConvidados().size(); xx++){
            for(Utilizador utilizadore : utilizadores){
                if(utilizadore.getUserName().equals(autenticado.getProjetos().get(posicao).getConvidados().get(xx))){
                    for (int xa = 0; xa < utilizadore.getProjetos().size(); xa++) {
                        if (autenticado.getProjetos().get(posicao) == utilizadore.getProjetos().get(xa)) {
                            utilizadore.getProjetos().remove(xa);
                            break;
                        }
                    }
                }
            }
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
        System.out.println(" 7  - Listar tarefas por intervalo");
        System.out.println(" 9  - Listar convites");
        System.out.println(" 11 - Imprimir relatorio pessoal do mês");
        System.out.println(" 12 - Imprimir relatorio mensal");
        System.out.println(" 0  - LOGOUT");
    }

    @Override
    public Utilizador choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores,ArrayList<Convite> convites) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatMes = new SimpleDateFormat("MM/yyyy");

        Scanner scan = new Scanner(System.in);
        switch(op){
            case 0:{
                autenticado = null;
                System.out.println("Logout com sucesso");
                break;
            }
            case 1:{

                /**
                 * Função que permite ao utilizador alterar os seus dados
                 */
                int op1;

                op1=inputInt("Dado a alterar:\n1 - Username\n2 - Nome\n3 - Password\n4 - Profissão\n5 - Contacto\n6 - Preço/Hora Default\n0 - Sair\n",scan);

                if(op1 == 0){
                    break;
                }
                autenticado.AlterarDados(op1);
                break;
            }
            case 2:{
                /**
                 * Criação de Projetos que reconhece se algum preço/Hora é introduzido
                 */

                System.out.println("Criar um projeto");
                System.out.println("---------");
                System.out.println("Nome do projeto: ");
                String nomePadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Nome do cliente: ");
                String nomeCadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Preço por hora: (nada para preço default)");
                String precoadd = scan.nextLine();
                float precoPorHoraadd = 0.0f;
                if(!precoadd.isBlank()){
                    precoPorHoraadd = Float.parseFloat(precoadd);
                }

                if(precoPorHoraadd!=0.0f){
                    autenticado.novoProjeto(new projeto(nomePadd,nomeCadd,autenticado.getUserName(),autenticado.getNome(),precoPorHoraadd));
                }
                else{
                    autenticado.novoProjeto(new projeto(nomePadd,nomeCadd,autenticado.getUserName(),autenticado.getNome(),autenticado.getPrecoDefault()));
                }
                break;
            }
            case 3:{
                /**
                 * Manipulação de dados dos projetos, com um submenu dedicado
                 */
                    int alterarProjeto2;
                    int alterarProjeto=999;
                    do {

                        alterarProjeto2 = inputInt("-------------------\n1 - Selecionar um projeto\n2 - Convidar Utilizador\n3 - Remover Projeto\n4 - Remover Convidados\n5 - Adicionar tarefa\n6 - Alterar Tarefa\n0 - Sair\n-------------------", scan);
                        switch (alterarProjeto2) {
                            case 1: {
                                /**
                                 * Esta função serve para o utilizador selecionar um projeto, caso contrário não conseguirá fazer qualquer outra das opções
                                 */
                                for (int j = 0; j < autenticado.getProjetos().size(); j++) {
                                    System.out.println("Num: "+j);
                                    System.out.println(autenticado.getProjetos().get(j).toString());
                                }
                                System.out.println();

                                alterarProjeto = inputInt("Selecione Projeto a alterar: (999 para cancelar)", scan);
                                scan.nextLine();

                                break;
                            }
                            case 2: {
                                /**
                                 * Função que permite o convite de novos utilizadores para o projeto (caso quem tente fazer o convite seja o criador do projeto)
                                 */
                                if (alterarProjeto!=999) {
                                    if (autenticado.getProjetos().get(alterarProjeto).isAuthor(autenticado.getUserName())) {
                                        scan.nextLine();
                                        System.out.println("Profissão do convidado: ");
                                        String profConvidado = scan.nextLine();
                                        for (Utilizador utilizadore : utilizadores) {
                                            if (utilizadore.toStringReduzido() != null && utilizadore.getProfissao().equals(profConvidado)) {
                                                System.out.println(utilizadore.toStringReduzido());
                                            }
                                        }
                                        scan.nextLine();
                                        System.out.println("username do utilizador a convidar:");
                                        String convidado = scan.nextLine();
                                        boolean sucesso=false;
                                        for (Utilizador utilizadore : utilizadores) {
                                            if (utilizadore.getUserName().equals(convidado)) {
                                                convites.add(new Convite(autenticado.getUserName(), utilizadore.getUserName(), autenticado.getProjetos().get(alterarProjeto)));
                                                sucesso=true;
                                                break;
                                            }
                                        }
                                        if(!sucesso){
                                            System.out.println("Utilizador não encontrado");
                                        }
                                    } else {
                                        System.out.println("Sem permissão para realizar convites no projeto selecionado");
                                    }
                                }
                                else{
                                    System.out.println("Sem projeto selecionado / Sem permissão");
                                }
                                break;
                            }
                            case 3: {
                                /**
                                 * Função para a remoção do projeto selecionado, caso seja escolhida a opção de desassociar tarefas o que acontece é que as tarefas do projeto
                                 * são adicionadas ao Arraylist das tarefas independentes do utilizador autenticado e posteriormente a eliminação do projeto no Arraylist de projetos dos convidados
                                 */
                                if (alterarProjeto!=999 && autenticado.getProjetos().get(alterarProjeto).isAuthor(autenticado.getUserName())) {
                                    int alterarProjeto3;
                                    alterarProjeto3 = inputInt("\n1 - Eliminar todas as tarefas\n2 - Desassociar todas as tarefas", scan);
                                    scan.nextLine();
                                    if (alterarProjeto3 == 1) {

                                            autenticado.getProjetos().get(alterarProjeto).getTarefas().clear();

                                        eliminaProjetoConvidados(autenticado,utilizadores,alterarProjeto);
                                        autenticado.getProjetos().remove(alterarProjeto);
                                        break;
                                    }
                                    if (alterarProjeto3 == 2) {
                                        for (int xi = 0; xi < autenticado.getProjetos().get(alterarProjeto).getTarefas().size(); xi++) {
                                            autenticado.getTarefas().add(autenticado.getProjetos().get(alterarProjeto).getTarefas().get(xi));
                                        }
                                        eliminaProjetoConvidados(autenticado,utilizadores,alterarProjeto);
                                        autenticado.getProjetos().remove(alterarProjeto);
                                        alterarProjeto = 999;
                                        break;
                                    }
                                } else {
                                    System.out.println("Sem projeto selecionado / Sem permissão");
                                    break;
                                }
                            }
                            case 4: {
                                /**
                                 * Função que permite eliminar um convidado específico do projeto, removendo do arraylist de projetos desse utilizador o projeto em questão
                                 */
                                if (alterarProjeto!=999 && autenticado.getProjetos().get(alterarProjeto).isAuthor(autenticado.getUserName())) {
                                    for (int xu = 0; xu < autenticado.getProjetos().get(alterarProjeto).getConvidados().size(); xu++) {
                                        System.out.println("ID Convidado: " + xu);
                                        System.out.println(autenticado.getProjetos().get(alterarProjeto).toStringConvidados(xu));
                                    }
                                    int alterarProjeto4;
                                    alterarProjeto4 = inputInt("ID de convidado a remover: ", scan);
                                    for (Utilizador utilizadore : utilizadores) {
                                        if (utilizadore.getUserName().equals(autenticado.getProjetos().get(alterarProjeto).getConvidados().get(alterarProjeto4))) {
                                            for (int xa = 0; xa < utilizadore.getProjetos().size(); xa++) {
                                                if (autenticado.getProjetos().get(alterarProjeto) == utilizadore.getProjetos().get(xa)) {
                                                    utilizadore.getProjetos().remove(xa);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Sem projeto selecionado / Sem permissão");
                                }
                                break;
                            }
                            case 5:{
                                /**
                                 * Função de criação de tarefas associadas automaticamente ao projeto atual
                                 */
                                if(alterarProjeto!=999){
                                    scan.nextLine();
                                    System.out.println("Criar uma tarefa ");
                                    System.out.println("---------");
                                    System.out.println("Nome: ");
                                    String nomeadd = scan.nextLine();
                                    System.out.println("---------");
                                    System.out.println("Descrição: ");
                                    String descricaoadd = scan.nextLine();
                                    System.out.println("---------");
                                    System.out.println("Data de inicio: (DD/MM/YYYY HH:mm)");
                                    String dataIniciounformated = scan.nextLine();
                                    Date dataInicio;
                                    if(!dataIniciounformated.isBlank()){
                                        dataInicio = format.parse(dataIniciounformated);
                                        autenticado.getProjetos().get(alterarProjeto).getTarefas().add(new tarefa(autenticado.getUserName(),nomeadd,descricaoadd,dataInicio,autenticado.getProjetos().get(alterarProjeto).getPrecoHora()));

                                    }
                                    else{
                                        autenticado.getProjetos().get(alterarProjeto).getTarefas().add(new tarefa(autenticado.getUserName(),nomeadd,descricaoadd,autenticado.getProjetos().get(alterarProjeto).getPrecoHora()));
                                    }
                                }
                                else{
                                    System.out.println("Sem projeto selecionado / Sem permissão");
                                }
                            }
                            case 6:{
                                if (alterarProjeto!=999) {
                                    int alterarTarefa2P;
                                    int alterarTarefaP = 999;
                                    int alterarTarefa3P = 999;
                                    do {
                                        alterarTarefa2P = inputInt("-------------------\n1 - Selecionar uma Tarefa\n2 - Terminar Tarefa\n3 - Remover Tarefa\n0 - Sair\n-------------------", scan);
                                        switch (alterarTarefa2P) {
                                            case 1: {
                                                for (int kl = 0; kl < autenticado.getProjetos().get(alterarProjeto).getTarefas().size(); kl++) {
                                                    System.out.println("Num: "+kl);
                                                    System.out.println(autenticado.getProjetos().get(alterarProjeto).getTarefas().get(kl).toString());
                                                }

                                                alterarTarefaP = inputInt("Selecione a tarefa a alterar: (999 para cancelar)", scan);
                                                scan.nextLine();
                                                break;
                                            }
                                            case 2: {
                                                if (alterarTarefaP!=999) {
                                                    if (autenticado.getProjetos().get(alterarProjeto).getTarefas().get(alterarTarefaP).getDataHorafim() == null) {
                                                        scan.nextLine();
                                                        System.out.println("Data de fim: (DD/MM/YYYY HH:mm)");
                                                        String dataFimPt = scan.nextLine();
                                                        Date dataFimAddPt;
                                                        if (!dataFimPt.isBlank()) {
                                                            dataFimAddPt = format.parse(dataFimPt);
                                                            autenticado.getProjetos().get(alterarProjeto).getTarefas().get(alterarTarefaP).terminarTarefa(dataFimAddPt);
                                                            break;
                                                        } else {
                                                            autenticado.getProjetos().get(alterarProjeto).getTarefas().get(alterarTarefaP).terminarTarefa();
                                                            break;
                                                        }
                                                    } else {
                                                        System.out.println("Tarefa já está terminada");
                                                        break;
                                                    }
                                                }
                                            }
                                            case 3: {
                                                if (alterarTarefaP != 999) {
                                                    if (autenticado.getTarefas().get(alterarTarefaP).isAuthor(autenticado.getUserName())) {
                                                        int opApagar;

                                                        opApagar = inputInt("Confirmação:\n1 - Apagar\n2 - Cancelar", scan);
                                                        switch (opApagar) {
                                                            case 1: {
                                                                autenticado.getProjetos().get(alterarProjeto).getTarefas().remove(alterarTarefaP);
                                                                alterarTarefaP = 999;
                                                                break;
                                                            }
                                                            case 2: {
                                                                System.out.println("Cancelado com sucesso");
                                                                break;
                                                            }
                                                            default: {
                                                                System.out.println("Existem apenas 2 opçoes");
                                                            }
                                                        }
                                                        break;
                                                    }
                                                } else {
                                                    System.out.println("Sem projeto selecionado / Sem permissão");
                                                    break;
                                                }
                                            }
                                        }
                                    }while(alterarTarefa2P!=0);
                                }
                            }
                            case 0: {
                                System.out.println("Voltando ao menu anterior");
                            }
                        }
                    }while(alterarProjeto2!=0);
                break;
            }
            case 4:{
                /**
                 * Função para criar tarefas independentes
                 */
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
                System.out.println("---------");
                System.out.println("Preço por hora: (nada para preço default)");
                String precoadd = scan.nextLine();
                float precoPorHoraaddTarefa = 0.0f;
                if(!precoadd.isBlank()){
                    precoPorHoraaddTarefa = Float.parseFloat(precoadd);
                }

                Date dataAdd;
                if(!dataInicio.isBlank()){
                    if(precoPorHoraaddTarefa!=0.0f){
                        dataAdd = format.parse(dataInicio);
                        autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd, dataAdd,precoPorHoraaddTarefa));
                    }
                    else{
                        dataAdd = format.parse(dataInicio);
                        autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd, dataAdd,autenticado.getPrecoDefault()));
                    }
                }
                else{
                    if(precoPorHoraaddTarefa!=0.0f){
                        autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd,precoPorHoraaddTarefa));
                    }
                    else{
                        autenticado.novaTarefa(new tarefa(autenticado.getUserName(), nomeadd, descricaoadd,autenticado.getPrecoDefault()));
                    }
                }
                break;
            }
            case 5:{
                /**
                 * Função para manipulação de tarefas com funcionamente equivalente à de manipulação de projetos
                 */

                int alterarTarefa2;
                int alterarTarefa = 999;
                int alterarTarefa3 = 999;
                do {
                    alterarTarefa2 = inputInt("-------------------\n1 - Selecionar uma Tarefa\n2 - Terminar Tarefa\n3 - Remover Tarefa\n4 - Associar a Projeto\n0 - Sair\n-------------------", scan);
                    switch (alterarTarefa2) {
                        case 1: {
                            for (int k = 0; k < autenticado.getTarefas().size(); k++) {
                                System.out.println("-------------------");
                                System.out.println("Num: "+k);
                                System.out.println(autenticado.getTarefas().get(k).toString());
                                System.out.println("-------------------");
                            }

                            alterarTarefa = inputInt("Selecione a tarefa a alterar: (999 para cancelar)", scan);
                            scan.nextLine();
                            break;
                        }
                        case 2: {
                            if(alterarTarefa!=999){
                                if (autenticado.getTarefas().get(alterarTarefa).getDataHorafim() == null) {
                                    scan.nextLine();
                                    System.out.println("Data de fim: (DD/MM/YYYY HH:mm)");
                                    String dataFim = scan.nextLine();
                                    Date dataFimAdd;
                                    if (!dataFim.isBlank()) {
                                        dataFimAdd = format.parse(dataFim);
                                        autenticado.getTarefas().get(alterarTarefa).terminarTarefa(dataFimAdd);
                                        break;
                                    } else {
                                        autenticado.getTarefas().get(alterarTarefa).terminarTarefa();
                                        break;
                                    }
                                } else {
                                    System.out.println("Tarefa já está terminada");
                                    break;
                                }
                            }
                            break;
                        }
                        case 3: {
                            if (alterarTarefa!=999 && autenticado.getTarefas().get(alterarTarefa).isAuthor(autenticado.getUserName())) {
                                int opApagar;
                                    opApagar = inputInt("Confirmação:\n1 - Apagar\n2 - Cancelar", scan);
                                    switch (opApagar) {
                                        case 1:{
                                            autenticado.getTarefas().remove(alterarTarefa);
                                            alterarTarefa=999;
                                            break;
                                        }

                                        case 2:{
                                            System.out.println("Cancelado com sucesso");
                                            break;
                                        }

                                        default:{
                                            System.out.println("Existem apenas 2 opçoes");
                                            break;
                                        }
                                    }
                            }
                            else{
                                System.out.println("Sem tarefa selecionado / Sem permissão");
                            }
                            break;
                        }
                        case 4: {
                            if (alterarTarefa != 999) {
                                for (int xac = 0; xac < autenticado.getProjetos().size(); xac++) {
                                    System.out.println("Num: "+xac);
                                    System.out.println(autenticado.getProjetos().get(xac).toString());
                                }
                                scan.nextLine();
                                alterarTarefa3 = inputInt("selecione Projeto: (999 para cancelar)", scan);
                                scan.nextLine();
                                if (alterarTarefa3 != 999) {
                                    autenticado.getProjetos().get(alterarTarefa3).getTarefas().add(autenticado.getTarefas().get(alterarTarefa));
                                    autenticado.getTarefas().remove(alterarTarefa);
                                }
                            }
                            else{
                                System.out.println("Sem tarefa selecionado / Sem permissão");
                            }
                            alterarTarefa=999;
                            break;
                        }
                    }
                }while(alterarTarefa2!=0);
                break;
            }
            case 6:{
                break;
            }
            case 7:{
                /**
                 * Função para imprimir todas as tarefas do utilizador que tenham sido iniciadas dentro dos prazos estabelecidos
                 */
                System.out.println("Introduza a data de início: (DD/MM/YYYY)");
                String datainicialunformated = scan.nextLine();
                Date dataInicial = format1.parse(datainicialunformated);
                System.out.println("Introduza a data de fim: (DD/MM/YYYY)");
                String dataFinalunformated = scan.nextLine();
                Date dataFinal = format1.parse(dataFinalunformated);
                autenticado.tarefasIntervalo(dataInicial,dataFinal);
                break;
            }
            case 9:{
                /**
                 * Função para saber os convites recebidos pelo utilizador associados a cada projeto
                 */
                int i;
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
                    }
                }
                break;
            }
            case 11:{
                System.out.println("Introduza o mês:(MM/YYYY)");
                String mesunformated = scan.nextLine();
                Date mes = formatMes.parse(mesunformated);
                autenticado.relatorioMes(mes);
                break;
            }
            case 12:{
                Date mesatualunformated = new Date();
                autenticado.relatorioMes(mesatualunformated);
                System.out.println("Ficheiro criado com sucesso");
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

