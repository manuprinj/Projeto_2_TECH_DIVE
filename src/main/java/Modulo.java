import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import types.StatusModulo;


public class Modulo {

    private Trilha trilha;
    private String nomeModulo;
    private String habilidades;
    private String tarefaValidacao;
    private LocalDate prazoLimite;
    private StatusModulo statusModulo;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Modulo(Trilha trilha, String nomeModulo, String habilidades, String tarefaValidacao, LocalDate prazoLimite,
            StatusModulo statusModulo) {
        this.trilha = trilha;
        this.nomeModulo = nomeModulo;
        this.habilidades = habilidades;
        this.tarefaValidacao = tarefaValidacao;
        this.prazoLimite = prazoLimite;
        this.statusModulo = statusModulo;
    }

    public boolean isModuloEmAvaliacao() {
        return statusModulo == StatusModulo.FASE_DE_AVALIACAO && !prazoLimite.isBefore(LocalDate.now());
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getTarefaValidacao() {
        return tarefaValidacao;
    }

    public void setTarefaValidacao(String tarefaValidacao) {
        this.tarefaValidacao = tarefaValidacao;
    }

    public LocalDate getPrazoLimite() {
        return prazoLimite;
    }

    public void setPrazoLimite(LocalDate prazoLimite) {
        this.prazoLimite = prazoLimite;
    }

    public StatusModulo getStatus() {
        return statusModulo;
    }

    public void setStatus(StatusModulo statusModulo) {
        this.statusModulo = statusModulo;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
