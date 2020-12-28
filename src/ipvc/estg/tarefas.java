package ipvc.estg;


import java.util.Date;

public class tarefas {

    private int numProjeto;
    private String nome;
    private String descricao;
    private Date dataHoraInicio;
    private Date getDataHorafim;


    public tarefas() {
        this.numProjeto=0;
        this.dataHoraInicio= new Date();
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

    public Date getGetDataHorafim() {
        return getDataHorafim;
    }

    public void setGetDataHorafim(Date getDataHorafim) {
        this.getDataHorafim = getDataHorafim;
    }
}
