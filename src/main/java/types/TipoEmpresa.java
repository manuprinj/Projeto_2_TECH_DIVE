package types;


public enum TipoEmpresa {

    MATRIZ("Matriz"),
    FILIAL("Filial");

    private final String nome;

    TipoEmpresa(String nome) {
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
