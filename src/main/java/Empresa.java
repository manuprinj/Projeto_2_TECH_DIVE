import static utils.CNPJUtils.getMascaraCNPJ;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import types.Estados;
import types.RegionaisSENAI;
import types.Segmentos;
import types.TipoEmpresa;


public class Empresa {

    private String  nomeEmpresa;
    private String cnpj;
    private TipoEmpresa tipo;
    private String nomeFilial;
    private Segmentos segmento;
    private String cidade;
    private Estados estado;
    private RegionaisSENAI regional;
    private List<Trilha> trilhas = new ArrayList<>();

    public Empresa(String nomeEmpresa, String cnpj, TipoEmpresa tipo, Segmentos segmento, String cidade, Estados estado,
            RegionaisSENAI regional) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.segmento = segmento;
        this.cidade = cidade;
        this.estado = estado;
        this.regional = regional;
    }

    public Empresa(String nomeEmpresa, String cnpj, TipoEmpresa tipo, String nomeFilial, Segmentos segmento,
            String cidade, Estados estado, RegionaisSENAI regional) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.nomeFilial = nomeFilial;
        this.segmento = segmento;
        this.cidade = cidade;
        this.estado = estado;
        this.regional = regional;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("Nome: " + getNomeEmpresa())
                .add("CNPJ: " + getMascaraCNPJ(getCnpj()))
                .add("Tipo de Empresa: " + getTipo())
                .add("Nome da Filial: " + getNomeFilial())
                .add("Segmento: " + getSegmento())
                .add("Cidade: " + getCidade())
                .add("Estado: " + getEstado())
                .add("Regional: " + getRegional());

        return joiner.toString();
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public Segmentos getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmentos segmento) {
        this.segmento = segmento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public RegionaisSENAI getRegional() {
        return regional;
    }

    public void setRegional(RegionaisSENAI regional) {
        this.regional = regional;
    }

    public List<Trilha> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(List<Trilha> trilhas) {
        this.trilhas = trilhas;
    }
}
