package ipvc.estg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class LoginInterface extends JFrame implements ActionListener {

    private static JLabel label;
    private static JLabel passwordLabel;
    private static JTextField userTexte;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel sucess;
    private boolean res = true;
    private Object List;
    private Object Utilizador;

    public LoginInterface(){


        JPanel panel = new JPanel();

        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);

        panel.setLayout(null);
        label = new JLabel("User:");

        label.setBounds(10, 20,80,25);
        panel.add(label);
        userTexte = new JTextField(20);
        userTexte.setBounds(100, 20, 165, 25);
        panel.add(userTexte);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(e-> {
            try {
                login();
            } catch (DataFormatException dataFormatException) {
                dataFormatException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            catch (ClassNotFoundException classNotFoundException){
                classNotFoundException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });
        panel.add(button);

        sucess = new JLabel("");
        sucess.setBounds(10,120,300,25);
        panel.add(sucess);


        this.setVisible(true);


    }





    public void login() throws DataFormatException, IOException, ClassNotFoundException, ParseException {

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

        if(!users.exists() && !users.isDirectory()){
            //ArrayList<Utilizador> utilizadores =  new ArrayList<>();
            Admin init;
            init = new Admin("admin", "admin", "admin", "admin", "admin");
            utilizadores.add(init);
            init.save("utilizadores.tmp");
            init =new Admin("admin1", "admin1", "admin1", "admin", "admin");
            utilizadores.add(init);
            init.save("utilizadores.tmp");
            init.save("utilizadores.tmp");
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

