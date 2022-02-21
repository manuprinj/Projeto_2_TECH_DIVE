import java.util.List;

import types.PerfilAcesso;


public class Usuario {
    private String nomeTrabalhador;
    private String cpf;
    private String email;
    private String senha;
    private List<PerfilAcesso> perfis;

    public Usuario(String nomeTrabalhador, String cpf, String email, String senha, List<PerfilAcesso> perfis) {
        this.nomeTrabalhador = nomeTrabalhador;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.perfis = perfis;
    }

    public String getNomeTrabalhador() {
        return nomeTrabalhador;
    }

    public void setNomeTrabalhador(String nomeTrabalhador) {
        this.nomeTrabalhador = nomeTrabalhador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PerfilAcesso> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<PerfilAcesso> perfis) {
        this.perfis = perfis;
    }
}
