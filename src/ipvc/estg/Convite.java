package ipvc.estg;

public class Convite {
    private static int indice=0;
    private int num;
    private String autor;
    private String convidado;
    private tarefa tarefa;

    public Convite(String autor,String convidado,tarefa tarefa){
        this.num = this.indice++;
        this.autor = autor;
        this.convidado = convidado;
        this.tarefa = tarefa;
    }

    public boolean isInvited(String convidado){
        return this.convidado.equals(convidado);
    }

    @Override
    public String toString(){
        return "Num: "+getNum()+"\nAutor: "+getAutor()+"\nNome da Tarefa: "+getTarefa().getNome();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isAuthor(String autor){
        return this.autor.equals(autor);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConvidado() {
        return convidado;
    }

    public void setConvidado(String convidado) {
        this.convidado = convidado;
    }

    public ipvc.estg.tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(ipvc.estg.tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
