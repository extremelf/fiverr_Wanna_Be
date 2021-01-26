package ipvc.estg;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilizador implements Serializable {


    private String userName;
    private String nome;
    private String password;
    private boolean isAdmin;
    private int idade;
    private String profissao;
    private String contacto;
    private int rating;
    private int horasDiarias;
    private int tarefasRealizadas;
    private int projetosRealizados;
    private float precoDefault;
    private ArrayList<tarefa> tarefas = new ArrayList<>();
    private ArrayList<projeto> projetos = new ArrayList<>();


    public Utilizador(String userName,String nome,String password, String profissao, String contacto) {
        this.rating = 0;
        this.tarefasRealizadas = 0;
        this.projetosRealizados = 0;
        this.nome = nome;
        this.password = password;
        this.profissao = profissao;
        this.userName = userName;
        this.contacto = contacto;
        this.isAdmin=false;
    }
    public Utilizador(String userName,String nome,String password, String profissao, String contacto,float precoDefault) {
        this.rating = 0;
        this.tarefasRealizadas = 0;
        this.projetosRealizados = 0;
        this.nome = nome;
        this.password = password;
        this.profissao = profissao;
        this.userName = userName;
        this.contacto = contacto;
        this.precoDefault=precoDefault;
        this.isAdmin=false;
    }

    public Menu getMenu(){return new UserMenu();
    }

    public boolean Login(String username, String password){
        return this.correctUsername(username) && this.correctPassword(password);
    }


    public void save(String filename) throws IOException, FileNotFoundException {
        try{
            FileOutputStream fos = new FileOutputStream("utilizadores.tmp",true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);

            oos.flush();
            oos.close();

            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void AlterarDados(int op){
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("opção:"+op);

        switch(op){
            case 1:{
                System.out.println("Novo username:");
                input=scan.nextLine();
                this.setUserName(input);
                break;
            }
            case 2:{
                System.out.println("Novo nome:");
                input=scan.nextLine();
                this.setNome(input);
                break;
            }
            case 3:{
                System.out.println("Nova password:");
                input=scan.nextLine();
                this.setPassword(input);
                break;
            }
            case 4:{
                System.out.println("Nova profissão:");
                input=scan.nextLine();
                this.setProfissao(input);
                break;
            }
            case 5:{
                System.out.println("Novo contacto:");
                input=scan.nextLine();
                this.setContacto(input);
                break;
            }
            case 6:{
                System.out.println("Horas de trabalho diarias:");
                input= String.valueOf(scan.nextInt());
                this.setHorasDiarias(horasDiarias);
            }

        }
    }

    public String toStringReduzido(){
        if(!this.isAdmin()){
            return "Username: "+userName+" Nome: "+nome+" Profissão: "+profissao+"\n";
        }
        else{
            return null;
        }
    }

    @Override
    public String toString(){
       return "Username: "+userName+" Password: "+password+" Nome: "+nome+" Profissão: "+profissao+" Contacto: "+contacto+"\n";
    }

    public void novoProjeto(projeto novoProjeto){this.projetos.add(novoProjeto);}

    public void novaTarefa(tarefa novaTarefa) {
        this.tarefas.add(novaTarefa);
    }

    //Getters and Setters


    public float getPrecoDefault() {
        return precoDefault;
    }

    public void setPrecoDefault(float precoDefault) {
        this.precoDefault = precoDefault;
    }

    public ArrayList<projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<projeto> projetos) {
        this.projetos = projetos;
    }

    public ArrayList<tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public boolean correctUsername(String username){
        return this.userName.equals(username);
    }

    public boolean correctPassword(String password){
        return this.password.equals(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;

    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getHorasDiarias() {
        return horasDiarias;
    }

    public void setHorasDiarias(int horasDiarias) {
        this.horasDiarias = horasDiarias;
    }

    public int getTarefasRealizadas() {
        return tarefasRealizadas;
    }

    public void setTarefasRealizadas(int tarefasRealizadas) {
        this.tarefasRealizadas = tarefasRealizadas;
    }

    public int getProjetosRealizados() {
        return projetosRealizados;
    }

    public void setProjetosRealizados(int projetosRealizados) {
        this.projetosRealizados = projetosRealizados;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void addUtilizador(String userName, String nome, String password, String profissao, String contacto ){


    }



}


