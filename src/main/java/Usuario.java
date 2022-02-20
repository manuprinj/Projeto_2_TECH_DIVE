import types.PerfilAcesso;


public class Usuario {
    private String nomeTrabalhador;
    private String cpf;
    private String email;
    private String senha;
    private PerfilAcesso perfilAcesso;

    public Usuario(String nomeTrabalhador, String cpf, String email, String senha, PerfilAcesso perfilAcesso) {
        this.nomeTrabalhador = nomeTrabalhador;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.perfilAcesso = perfilAcesso;
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

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
}
