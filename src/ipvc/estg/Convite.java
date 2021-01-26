package ipvc.estg;

public class Convite {
    private String autor;
    private String convidado;
    private projeto projeto;

    public Convite(String autor,String convidado,projeto projeto){
        this.autor = autor;
        this.convidado = convidado;
        this.projeto = projeto;
    }

    public boolean isInvited(String convidado){
        return this.convidado.equals(convidado);
    }

    @Override
    public String toString(){
        return "\nAutor: "+getAutor()+"\nNome do Projeto: "+getProjeto().getNomeProjeto();
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

    public ipvc.estg.projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(ipvc.estg.projeto projeto) {
        this.projeto = projeto;
    }
}
