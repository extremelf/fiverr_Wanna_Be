package ipvc.estg;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

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
    public int choose(int op, Utilizador autenticado, ArrayList<Utilizador> utilizadores) throws IOException, DataFormatException {
        File dataUsersFile = new File("C:\\Users\\Utilizador\\JavaProjectsPII\\fiverr_Wanna_Be\\ dadosUtilizadores.txt");
        Scanner scan = new Scanner(System.in);
        int i=1;
        switch(op){
            case 0:{
                i=0;
                break;
            }
            case 1:{
                System.out.println("Criar um utilizador");
                System.out.println(" Insira o USERNAME do utilizador a ser criado:");
                String useradd = scan.nextLine();
                System.out.println("---------");
                for (int u = 0; u < utilizadores.size(); u++) {                 //
                                                                                //
                    if (utilizadores.get(u).correctUsername(useradd)) {         // ESTE CICLO FUNCIONA MAS A EXCEPTION ACABA COM O PROGRAMA E ISSO NAO É O DESEJADO XD
                        throw new DataFormatException("Utilizador já existe");  //
                    }                                                           //
                }                                                               //
                System.out.println("Password a inserir: ");
                String passwordaad = scan.nextLine();
                System.out.println("---------");
                System.out.println("Nome: ");
                String nomeadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Profissao: ");
                String profissaoadd = scan.nextLine();
                System.out.println("---------");
                System.out.println("Contacto: ");
                String contactadd = scan.nextLine();
                /**
                 * TEMOS DE ESPECIFICAR O QUE VAI SER O CONTACTO, É UM EMAIL OU NUMERO DE CONTATO?
                 * ISTO PQ O CONTACTO TB NAO PODE SER IGUAL PARA NENHUM UTILIZADOR QUER SEJA EMAIL OU NUMERO TELEFONICO
                 * ACHO MELHOR CRIARMOS MAIS UMA VARIAVEL EMAIL NOS UTILIZADORES
                 * DEPOIS PODEMOS EXEÇOES PARA UM E OUTRO, POR EXEMPLO UM METODO PARA AVERIGUAR SE O CONTACTO SAO NUMEROS E PARA NAO PASSAR DE 10 DIGITOS POR EXEMPLO
                 * NO CASO DO EMAIL TERIAMOS DE VERIFICAR SE NA STRING EXISTE '@' PARA SER UM EMAIL VALIDO
                 * DIZ ME O QUE ACHAS DEPOIS POR MENSAGEM OU ESCREVE TB AÍ EM COMENTARIO
                 */

                utilizadores.add(new Utilizador(useradd, nomeadd, passwordaad, profissaoadd, contactadd));




                /**
                 * TENTATIVA DE COLOCAR A GUARDAR EM FICHEIRO
                 * ele dá um simples erro por causa de uma exception, podes descomentar para veres, o problema está na linha 79 com o 'charSequence'
                FileWriter fileWr = new FileWriter(dataUsersFile, true);
                BufferedWriter fileBw = new BufferedWriter(fileWr);

                PrintWriter filePw = new PrintWriter(fileBw);

                filePw.append("\n");
                filePw.append((CharSequence) new Utilizador(useradd, nomeadd, passwordaad, profissaoadd, contactadd));

                filePw.close();

                 * DEPOIS PARA LER FUNCIONA DA MESMA FORMA MAS COM UM FileReader

                */


                break;
            }

            case 2:{
                for(int j = 0; j < utilizadores.size(); j++){
                    System.out.println("Nome:"+utilizadores.get(j).getNome()+" Profissão:"+utilizadores.get(j).getProfissao()+" Contacto:"+utilizadores.get(j).getContacto());
                    System.out.println("-----------------");
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
