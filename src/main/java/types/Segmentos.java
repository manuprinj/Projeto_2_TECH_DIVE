package types;


public enum Segmentos {

    ALIMENTOS_E_BEBIDAS("Alimentos e Bebidas"),
    CELULOSE_E_PAPEL("Celulose e Papel"),
    CONSTRUCAO("Construção"),
    ESQUIPAMENTOS_ELETRICOS("Equipamentos Elétricos"),
    FARMACOS_E_EQUIPAMENTOS_SAUDE("Fármacos e Equipamentos de Saúde"),
    FUMO("Fumo"),
    INDUSTRIA_AUTOMOTIVA("Indústria Automotiva"),
    INDUSTRIA_CERAMICA("Indústria Cerâmica"),
    INDUSTRIA_DIVERSA("Indústria Diversa"),
    INDUSTRIA_EXTRATIVA("Indústria Extrativa"),
    INDUSTRIA_GRAFICA("Indústria Gráfica"),
    MADEIRA_E_MOVEIS("Madeira e Móveis"),
    MAQUINAS_E_EQUIPAMENTOS("Máquinas e Equipamentos"),
    METALMECANICA_E_METALURGIA("Metalmecânica e Metalurgia"),
    OLEO_GAS_E_ELETRICIDADE("Óleo, Gás e Eletricidade"),
    PRODUTOS_QUIMICOS_E_PLASTICOS("Produtos Químicos e Plásticos"),
    SANEAMENTO_BASICO("Saneamento Básico"),
    TIC("TIC"),
    TEXTIL_CONFECCAO_COURA_E_CALCADOS("Têxtil, Confecção, Couro e Calçados");

    private final String nome;

    Segmentos(String nome) {
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
