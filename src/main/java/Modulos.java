import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import types.Status;


public class Modulos {

    private String trilha;
    private String nomeModulo;
    private List<String> habilidades = new ArrayList<>();
    private String tarefaValidacao;
    private LocalDate prazoLimite;
    private Status status;

    public Modulos(String trilha, String nomeModulo, List<String> habilidades, String tarefaValidacao, LocalDate prazoLimite,
            Status status) {
        this.trilha = trilha;
        this.nomeModulo = nomeModulo;
        this.habilidades = habilidades;
        this.tarefaValidacao = tarefaValidacao;
        this.prazoLimite = prazoLimite;
        this.status = status;
    }

    public String getTrilha() {
        return trilha;
    }

    public void setTrilha(String trilha) {
        this.trilha = trilha;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
