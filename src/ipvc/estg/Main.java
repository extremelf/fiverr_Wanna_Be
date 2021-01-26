package ipvc.estg;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import jdk.jshell.execution.Util;


public class Main {

    public static void main(String[] args) throws Exception {
        int op=0;
        int op1=0;
        Scanner scan = new Scanner(System.in);

        String loginUser;
        String password;
        ArrayList<Utilizador> utilizadores = new ArrayList<>();
        ArrayList<Convite> convites = new ArrayList<>();
        Utilizador autenticado;
        autenticado = null;
        boolean res = false;
        File users = new File("utilizadores.dat");
      //função para ler
        if(users.exists() && !users.isDirectory()){
            try{
                FileInputStream readData = new FileInputStream("utilizadores.dat");
                ObjectInputStream readStream = new ObjectInputStream(readData);
                utilizadores = (ArrayList<Utilizador>) readStream.readObject();
                readStream.close();
                //System.out.println(utilizadores.toString());
               /* for (int k = 0; k < utilizadores.size(); k++) {
                    for (int u = 0; u < utilizadores.get(k).getTarefas().size(); u++) {
                        System.out.println(utilizadores.get(k).getTarefas().get(u).toString());
                    }
                }*/
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(!users.exists() && !users.isDirectory()){
            //ArrayList<Utilizador> utilizadores =  new ArrayList<>();
            Admin init;
            init = new Admin("admin", "admin", "admin", "admin", "admin");
            utilizadores.add(init);
            init =new Admin("admin1", "admin1", "admin1", "admin", "admin");
            utilizadores.add(init);

        }

        do {

            String menu1="1 - Login\n2 - Criar conta\n0 - Sair";
            op1=inputInt(menu1,scan);

            switch(op1) {
                case 1: {
                    do {
                        scan.nextLine();
                        System.out.println("Faça login com as suas credenciais");

                        System.out.println("Username:");
                        loginUser = scan.nextLine();

                        System.out.println("Password:");
                        password = scan.nextLine();

                        for (int i = 0; i < utilizadores.size(); i++) {
                            res = utilizadores.get(i).Login(loginUser, password);
                            if (res) {
                                autenticado = utilizadores.get(i);
                                System.out.println("Sucesso");
                                break;
                            }
                        }
                    } while (!res);

                    do {
                        autenticado.getMenu().show();
                        op = scan.nextInt();
                        autenticado = autenticado.getMenu().choose(op, autenticado, utilizadores, convites);
                        scan.nextLine();
                    } while (autenticado != null);
                    break;
                }
                case 2:{
                    scan.nextLine();
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
                    System.out.println("email: ");
                    String contactadd = scan.nextLine();
                    System.out.println("---------");
                    float precoDefaultadd;
                    precoDefaultadd = inputFloat("Preço por hora default: ",scan);
                    Utilizador tmp;
                    tmp = new Utilizador(useradd, nomeadd, passwordaad, profissaoadd, contactadd,precoDefaultadd);
                    utilizadores.add(tmp);
                    break;
                }
                case 0: {
                    System.out.println("Adeus");
                    try{
                        FileOutputStream fos = new FileOutputStream("utilizadores.dat",false);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(utilizadores);

                        oos.flush();
                        oos.close();

                        fos.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }while(op1!=0);
    }


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
    public static float inputFloat(String out, Scanner scan){
        System.out.println(out);
        try{
            return scan.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Input errado, introduza um float!");
            scan.next();
            return inputFloat(out,scan);
        }
    }


    //new LoginInterface();

}