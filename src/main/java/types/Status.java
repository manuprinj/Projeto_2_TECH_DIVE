package types;


public enum Status {

    NAO_INICIADO("Curso não iniciado"),
    EM_ANDAMENTO("Curso em andamento"),
    FASE_DE_AVALIACAO("Em fase de avaliação"),
    AVALIACAO_FINALIZADA("Fase de avaliação finalizada");

    private final String nome;

    Status(String nome) {
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
