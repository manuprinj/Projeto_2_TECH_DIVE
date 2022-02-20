package types;


public enum RegionaisSENAI {

    NORTE_NORDESTE("Norte - Nordeste"),
    OESTE("Oeste"),
    SUDESTE("Sudeste"),
    CENTRO_NORTE("Centro - Norte"),
    VALE_DO_ITAJAI("Vale do Itajaí"),
    VALE_DO_ITAPOCU("Vale do Itapocu"),
    LITORAL_SUL("Litoral Sul"),
    ALTO_URUGUAI_CATARINENSE("Alto Uruguai Catarinense"),
    VALE_DO_ITAJAI_MIRIM("Vale do Itajaí Mirim"),
    CENTRO_OESTE("Centro - Oeste"),
    PLANALTO_NORTE("Planalto Norte"),
    FOZ_DO_RIO_ITAJAI("Foz do Rio Itajaí"),
    SUL("Sul"),
    SERRA_CATARINENSE("Serra Catarinense"),
    EXTREMO_OESTE("Extremo Oeste"),
    ALTO_VALE_DO_ITAJAI("Alto Vale do Itajaí");

    private final String nome;

    RegionaisSENAI(String nome) {
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
