package types;


public enum StatusModulo {

    NAO_INICIADO("Curso não iniciado"),
    EM_ANDAMENTO("Curso em andamento"),
    FASE_DE_AVALIACAO("Em fase de avaliação"),
    AVALIACAO_FINALIZADA("Fase de avaliação finalizada");

    private final String nome;

    StatusModulo(String nome) {
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
