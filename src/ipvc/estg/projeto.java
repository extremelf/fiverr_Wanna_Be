package ipvc.estg;

public abstract class projeto {

    private String nomeCliente;
    private String nome;
    private int precoHora;
    private int numProjeto;


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(int precoHora) {
        this.precoHora = precoHora;
    }

    public int getNumProjeto() {
        return numProjeto;
    }

    public void setNumProjeto(int numProjeto) {
        this.numProjeto = numProjeto;
    }
}
