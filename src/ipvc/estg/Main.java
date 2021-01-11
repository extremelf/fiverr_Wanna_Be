package ipvc.estg;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import jdk.jshell.execution.Util;

public class Main {

    public static void main(String[] args) throws IOException, DataFormatException, ParseException {
        int op=0;
        Scanner scan = new Scanner(System.in);

        String loginUser;
        String password;
        ArrayList<Utilizador> utilizadores = new ArrayList<>();
        ArrayList<Convite> convites = new ArrayList<>();
        Utilizador autenticado;
        autenticado = null;
        boolean res = false;
        File users = new File("utilizadores.tmp");
        /*if(users.exists() && !users.isDirectory()){
            try{
                FileInputStream readData = new FileInputStream("utilizadores.tmp");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                //ArrayList<Utilizador> utilizadores = (ArrayList<Utilizador>) readStream.readObject();
                readStream.close();
                System.out.println(utilizadores.toString());
            }catch(Exception e){
                e.printStackTrace();
            }
        }*/

        //if(!users.exists() && !users.isDirectory()){
            //ArrayList<Utilizador> utilizadores =  new ArrayList<>();
            Admin init;
            init = new Admin("admin", "admin", "admin", "admin", "admin");
            utilizadores.add(init);
            init.save("utilizadores.tmp");
            init =new Admin("admin1", "admin1", "admin1", "admin", "admin");
            utilizadores.add(init);

            utilizadores.add(new Utilizador("luis","Luís","1234","estudante","lpaulofernandes@ipvc.pt"));
            utilizadores.add(new Utilizador("jorge","Jorge","1234","estudante","jorge@gmail.com"));

            init.save("utilizadores.tmp");
            init.save("utilizadores.tmp");
      //  }

        do {
            do{
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
            }while(!res);

            do {
                autenticado.getMenu().show();
                op = scan.nextInt();
                autenticado=autenticado.getMenu().choose(op,autenticado,utilizadores,convites);
                scan.nextLine();
            }while(autenticado != null);
        }while(true);
    }
}