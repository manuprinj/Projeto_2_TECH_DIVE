import java.time.LocalDate;
import java.util.List;


public class Trabalhador {

    private String nome;
    private String cpf;
    private Empresa empresa;
    private String areaSetor;
    private String funcao;
    private LocalDate dataAlteracao;
    private List<Trilha> trilhas;
    private List<Modulo> modulos;

    public Trabalhador(String nome, String cpf, Empresa empresa, String areaSetor, String funcao,
            LocalDate dataAlteracao, List<Trilha> trilhas, List<Modulo> modulos) {
        this.nome = nome;
        this.cpf = cpf;
        this.empresa = empresa;
        this.areaSetor = areaSetor;
        this.funcao = funcao;
        this.dataAlteracao = dataAlteracao;
        this.trilhas = trilhas;
        this.modulos = modulos;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
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

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
}
