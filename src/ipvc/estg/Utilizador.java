package ipvc.estg;

import java.util.ArrayList;

public class Utilizador{


    private String userName;
    private String nome;
    private String password;
    private int idade;
    private String profissao;
    private String contacto;
    private int rating ;
    private int horasDiarias;
    private int tarefasRealizadas;
    private int projetosRealizados;
    public privilegio privilegio = ipvc.estg.privilegio.UTILIZADOR;
    private ArrayList<tarefas>tarefas;


    public Utilizador(String userName,String nome,String password, String profissao, String contacto) {
        this.rating = 0;
        this.tarefasRealizadas = 0;
        this.projetosRealizados = 0;
        this.nome = nome;
        this.password = password;
        this.profissao=profissao;
        this.userName=userName;
        this.contacto = contacto;
    }

    public Menu getMenu(){
        return new UserMenu();
    }

    public boolean Login(String username, String password){
        return this.correctUsername(username) && this.correctPassword(password);
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


 // vai buscar as tarefas (?)

    public ArrayList<ipvc.estg.tarefas> getTarefas() {


        return tarefas;
    }
}


