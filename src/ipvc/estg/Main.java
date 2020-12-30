package ipvc.estg;

import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;




    public class Main implements ActionListener {


        private static JLabel label;
        private static JLabel passwordLabel;
        private static JTextField userTexte;
        private static JPasswordField passwordText;
        private static JButton button;
        private static JLabel sucess;
        private boolean res = true;

        private static ArrayList<Utilizador> utilizadores = new ArrayList<>();



    public static void main(String[] args){


        System.out.println("here");



        int op = 0;

        //String admin = "admin";
        //String loginUser;
        //String password;
        //Scanner scan = new Scanner(System.in);
        //ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
        //Utilizador autenticado = null ;
        //boolean res = true;
        //Criar o admin por defeito
        // Não estou a conseguir verificar se está realmente vazio porque pode ter null e não deixa ver se está empty
        //if (utilizadores.isEmpty()) {





        /**
         * OK PERCEBI O TEU RACIOCINIO PARA A VERIFICAÇÃO DE EXISTENCIA DE UM USER OU NÃO, BASICAMENTE COLOCASTE QUE UM ADMIN É NA MESMA UM USER, E POR ISSO TEM QUE
         * TER PROFISSAO E CONTACTO TB INSERIDOS E VERIFICAS QUE O ARRAY ESTÁ VAZIO, MAS COMO INCIALIZAS O AUTENTICADO A NULL NAO TENS A CERTEZA SE O ARRAY ESTÁ
         * MESMO VAZIO OU NÃO, EM ISTO <<System.out.println(utilizadores.isEmpty());>> SEJA SEMPRE TRUE
         *
         * ACHEI AQUI UM PEQUENO ERRO DE CODIFICAÇÃO QUE NAO SEI PQ ACONTECE, SE TENTARES ADICONAR OUTRO ELEMENTE À ARRAYLIST COMO ESSE QUE EU TENHO AÍ O CODIGO NAO FUNCIONA COM
         * AS CREDENCIAIS,APENAS FUNCIONA COM "admin, admin" E A MESMA COISA PARA UM UTILIZADOR
         *
         * PERCEBI A FORMA QUE USASTE PARA RESOLVER O PROBLEMA DOS MENUS NA MAIN, DESTA FORMA ANULAMOS O USO DO ENUM DOS PREVILÉGIOS
         *
         * COM ISTO QUE FIZESTE ESTAVA A PENSAR QUE DEVERIAMOS CRIAR UMA CLASSE ABSTRACT "SUSER" EM QUE DEPOIS ADMIN, USERMANAGER E USER EXTENDESSEM DESSA CLASS EM VEZ DA QUE TEMOS
         * POIS ESSA ERA DERECIONADA PARA USER
         *
        */

            //utilizadores.add(new Admin("admin","admin","admin","admin","admin"));
            //utilizadores.add(new Admin("qwe", "qwe", " qwe", "qwe", "qwe"));
            //}
        //System.out.println(utilizadores.size());


        utilizadores.add(new Admin("qwe", "qwe", " qwe", "qwe", "qwe"));
        utilizadores.add(new Utilizador("Joelito","Joel", "123", "lala", "123455" ));

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

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
        button.addActionListener(new Main());
        panel.add(button);

        sucess = new JLabel("");
        sucess.setBounds(10,120,300,25);
        panel.add(sucess);


        frame.setVisible(true);


       /* do {
            System.out.println("Faça login com as suas credenciais");


            System.out.println("Username:");
            loginUser = scan.nextLine();

            System.out.println("Password:");
            password = scan.nextLine();

            for (int i = 0; i < utilizadores.size(); i++) {
                res = utilizadores.get(i).Login(loginUser, password);
                System.out.println(res);
                if (res) {
                    autenticado = utilizadores.get(i);
                    System.out.println("Sucesso");
                    break;
                }
            }
        } while (!res);*/
        /*do {


            autenticado.getMenu().show();
            op = scan.nextInt();

            switch (op) {
                case 1:
                    break;
                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                case 0:
                    break;

                default: System.out.println("Opção válida please");
            }

        }while (op!=0);
    }
*/
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            int op=0;
            Scanner scan = new Scanner(System.in);
            Utilizador autenticado = null;
            String loginUser = userTexte.getText();
            String password = passwordText.getText();
            System.out.println(loginUser + "," + password);

            for (int i = 0; i < utilizadores.size(); i++) {
                res = utilizadores.get(i).Login(loginUser, password);

                if (res) {
                    autenticado = utilizadores.get(i);
                    sucess.setText("Sucesso");
                    break;
                } else {
                    sucess.setText("Wrong pls try again");
                }

            }
            do {


                autenticado.getMenu().show();
                op = scan.nextInt();

                switch (op) {
                    case 1:
                        break;
                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        break;

                    case 6:
                        break;

                    case 7:
                        break;

                    case 8:
                        break;

                    case 9:
                        break;

                    case 10:
                        break;

                    case 11:
                        break;

                    case 0:
                        break;

                    default: System.out.println("Opção válida please");
                }

            }while (op!=0);
        }
        }




