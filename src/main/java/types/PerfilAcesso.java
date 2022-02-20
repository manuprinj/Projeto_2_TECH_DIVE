package types;


public enum PerfilAcesso {
    ADMINISTRATIVO("Administrativo (equipe SENAI)"),
    OPERACIONAL("Operacional (Supervisor da empresa)"),
    RH("RH (equipe RH)");

    private final String nome;

    PerfilAcesso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
