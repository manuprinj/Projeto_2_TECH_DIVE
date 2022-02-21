import java.util.List;

import types.PerfilAcesso;


public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private List<PerfilAcesso> perfis;

    public Usuario(String nome, String cpf, String email, String senha, List<PerfilAcesso> perfis) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.perfis = perfis;
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
