import java.util.List;
import java.util.StringJoiner;


public class Trilha {

    private String empresa;
    private String ocupacao;
    private int numeroSequencial;
    private String nomeTrilha;
    private String apelidoTrilha;
    private List<Modulos> modulos;
    private int nivelSatisfacao;
    private String anotacoes;

    public Trilha(String empresa, String ocupacao, int numeroSequencial, String nomeTrilha, String apelidoTrilha) {
        this.empresa = empresa;
        this.ocupacao = ocupacao;
        this.numeroSequencial = numeroSequencial;
        this.nomeTrilha = nomeTrilha;
        this.apelidoTrilha = apelidoTrilha;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("Nome Empresa: " + getEmpresa())
                .add("Ocupação: " + getOcupacao())
                .add("Número Sequencial: " + getNumeroSequencial())
                .add("Nome da Trilha: " + getNomeTrilha())
                .add("Apelido da Trilha: " + getApelidoTrilha());

        return joiner.toString();
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public int getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(int numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public void setNomeTrilha(String nomeTrilha) {
        this.nomeTrilha = nomeTrilha;
    }

    public String getApelidoTrilha() {
        return apelidoTrilha;
    }

    public void setApelidoTrilha(String apelidoTrilha) {
        this.apelidoTrilha = apelidoTrilha;
    }

    public List<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulos> modulos) {
        this.modulos = modulos;
    }

    public int getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(int nivelSatisfacao) {
        this.nivelSatisfacao = nivelSatisfacao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
}
