import java.time.LocalDate;
import java.util.List;


public class Trabalhador {

    private String nome;
    private String cpf;
    private String empresa;
    private String areaSetor;
    private String funcao;
    private LocalDate dataAlteracao;
    private List<Trilha> trilhas;
    private List<Modulos> modulos;
    private List<Integer> avaliacoes;

    public Trabalhador(String nome, String cpf, String empresa, String areaSetor, String funcao,
            LocalDate dataAlteracao, List<Trilha> trilhas, List<Modulos> modulos, List<Integer> avaliacoes) {
        this.nome = nome;
        this.cpf = cpf;
        this.empresa = empresa;
        this.areaSetor = areaSetor;
        this.funcao = funcao;
        this.dataAlteracao = dataAlteracao;
        this.trilhas = trilhas;
        this.modulos = modulos;
        this.avaliacoes = avaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAreaSetor() {
        return areaSetor;
    }

    public void setAreaSetor(String areaSetor) {
        this.areaSetor = areaSetor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public List<Trilha> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(List<Trilha> trilhas) {
        this.trilhas = trilhas;
    }

    public List<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulos> modulos) {
        this.modulos = modulos;
    }

    public List<Integer> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Integer> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
