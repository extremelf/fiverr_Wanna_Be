package ipvc.estg;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class tarefa implements Serializable {

    private static int contador=1;

    private int num;
    private int numProjeto;
    private String nome;
    private String descricao;
    private Date dataHoraInicio;
    private Date DataHorafim;
    private String autor;
    public tarefaStatus tarefastatus = tarefaStatus.OPEN;

    /**
     *Acho que arranjei a forma de ter as tarefas, basicamente vai guardar o autor ( o menu a apresentar as tarefas que um utilizador tem, vai mostrar as criadas por ele e as convidado
     *mas fará um check que mostrará aquelas que pode mexer(apagar e afins) e aquele que não pode, um simples boolean, estou ainda a pensar se vale a pena guardar um array com os convidados
     *já que não será usado para nada, apenas o "autor" para confirmar se tem permissao de autor ou não

     *O sistema de invites ainda não sei bem como pode funcionar mas o que vai fazer é, caso aceite, efetua uma copia da tarefa no array do autor,os convites vai ter de ser uma cena persistente
     *que não depende de logins efetuados, vai ter de ser um objeto novo que vai guardar as info do autor e convidado e a variavel da tarefa a guardar, para ver se um user tem convites aquilo corre
     *o array dos convites e quando tiver um match no "convidado"é mostrado
    */

    public tarefa(String autor, String nome, String descricao, Date inicio) {
        this.num = contador++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraInicio = inicio;
        this.autor=autor;
    }
    public tarefa(String autor, String nome, String descricao){
        this.num = contador++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraInicio = new Date();
        this.autor=autor;
    }

    /**
     *
     * Função usada para imprimir objetos desta classe
     * */
    @Override
    public String toString(){
        String str;
        String str1 = "Num "+getNum()+"\nNome: "+getNome()+"\nDescrição: "+getDescricao()+"\nAutor: "+getAutor()+"\nData/Hora Inicio: "+getDataHoraInicio()+ "\nEstado tarefa: "+tarefastatus;
        if(getDataHorafim()!=null){
            String str2 = "\nData/Hora Fim: "+getDataHorafim();
            str = str1.concat(str2);
        }
        else{
            str = str1;
        }
        return str;
    }

    public boolean isAuthor(String username){
        return this.autor.equals(username);
    }

    public void AssociarProjeto(int numProjeto){
        this.numProjeto = numProjeto;
    }

    /**
     * Existem dois terminares de tarefa, um existe caso não seja introduzida data no sistema utilizando a data do sistema atual, o outro recorre ao input do user
     *
     */

    public void terminarTarefa(){
        this.DataHorafim = new Date();
        this.tarefastatus = tarefaStatus.CLOSED;
    }

    public void terminarTarefa(Date fim) throws Exception {
        if(dataHoraInicio.after(fim)){
            throw new Exception(String.format("A data de ínicio (%s) deve ser anterior à data de fim (%s)", dataHoraInicio, fim));
        }
        else{
            this.DataHorafim = fim;
        }
        this.tarefastatus = tarefaStatus.CLOSED;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumProjeto() {
        return numProjeto;
    }

    public void setNumProjeto(int numProjeto) {
        this.numProjeto = numProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHorafim() {
        return DataHorafim;
    }

    public void setDataHorafim(Date dataHorafim) {
        this.DataHorafim = dataHorafim;
    }
}
