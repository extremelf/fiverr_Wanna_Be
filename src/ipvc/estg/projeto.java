package ipvc.estg;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class projeto implements Serializable {

    private String nomeProjeto;
    private String nomeCliente;
    private String autor;
    private String nomeCriador;
    private float precoHora;
    private ArrayList<tarefa> tarefas = new ArrayList<>();
    private ArrayList<String> convidados = new ArrayList<>();

    public projeto (String nomeProjeto, String nomeCliente, String autor, String nomeCriador,float precoHora){
        this.nomeProjeto = nomeProjeto;
        this.nomeCliente = nomeCliente;
        this.autor = autor;
        this.nomeCriador = nomeCriador;
        this.precoHora = precoHora;
    }

    public void novaTarefa(tarefa novaTarefa) {
        this.tarefas.add(novaTarefa);
    }

    @Override
    public String toString(){
        return "\nNome do Projeto: "+getNomeProjeto()+"\nNome do Cliente: "+getNomeCliente()+"\nPreço por hora: "+getPrecoHora();
    }

    public boolean isAuthor(String username){
        return this.autor.equals(username);
    }

    public String toStringConvidados(int n){
        return "\nUsername: "+getConvidados().get(n);
    }
    public void novoConvidado(String convidado){this.convidados.add(convidado);}

//Getters and Setters


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ArrayList<String> getConvidados() {
        return convidados;
    }

    public void setConvidados(ArrayList<String> convidados) {
        this.convidados = convidados;
    }

    public ArrayList<tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public float getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(float precoHora) {
        this.precoHora = precoHora;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
}
