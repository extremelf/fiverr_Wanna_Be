package ipvc.estg;


import java.util.ArrayList;
import java.util.Date;

public class tarefa {

    private static int contador=0;

    private int num;
    private int numProjeto;
    private String nome;
    private String descricao;
    private Date dataHoraInicio;
    private Date DataHorafim;
    private String autor;
    //ArrayList<String> convidados;

    /**
     *Acho que arranjei a forma de ter as tarefas, basicamente vai guardar o autor ( o menu a apresentar as tarefas que um utilizador tem, vai mostrar as criadas por ele e as convidado
     *mas fará um check que mostrará aquelas que pode mexer(apagar e afins) e aquele que não pode, um simples boolean, estou ainda a pensar se vale a pena guardar um array com os convidados
     *já que não será usado para nada, apenas o "autor" para confirmar se tem permissao de autor ou não

     *O sistema de invites ainda não sei bem como pode funcionar mas o que vai fazer é, caso aceite, efetua uma copia da tarefa no array do autor,os convites vai ter de ser uma cena persistente
     *que não depende de logins efetuados, vai ter de ser um objeto novo que vai guardar as info do autor e convidado e a variavel da tarefa a guardar, para ver se um user tem convites aquilo corre
     *o array dos convites e quando tiver um match no "convidado"é mostrado (quase como tinder XDD)
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

    @Override
    public String toString(){
        String str;
        String str1 = "Num"+getNum()+"\nNome: "+getNome()+"\nDescrição: "+getDescricao()+"\nAutor: "+getAutor()+"\nData/Hora Inicio: "+getDataHoraInicio();
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

    public void terminarTarefa(){
        this.DataHorafim = new Date();
    }

    public void terminarTarefa(Date fim) throws Exception {
        if(dataHoraInicio.after(fim)){
            throw new Exception(String.format("A data de ínicio (%s) deve ser anterior à data de fim (%s)", dataHoraInicio, fim));
        }
        else{
            this.DataHorafim = fim;
        }
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
