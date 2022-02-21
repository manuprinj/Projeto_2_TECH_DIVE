import java.util.StringJoiner;


public class Avaliacao {

    private Trabalhador trabalhador;
    private Modulo modulo;
    private Integer avaliacao;
    private String anotacoes;

    public Avaliacao(Trabalhador trabalhador, Modulo modulo, Integer avaliacao, String anotacoes) {
        this.trabalhador = trabalhador;
        this.modulo = modulo;
        this.avaliacao = avaliacao;
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ")
                .add("Trabalhador: " + trabalhador.getNome())
                .add("Avaliação: " + avaliacao)
                .add("Anotações: " + anotacoes)
                .toString();
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
}
