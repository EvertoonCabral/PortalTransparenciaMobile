package com.example.portaltransparencia.dto;


public class GastosDeputadosDTO {

    private int ano;
    private String cnpjCpfFornecedor;
    private int codDocumento;
    private int codLote;
    private int codTipoDocumento;
    private String dataDocumento;
    private int mes;
    private String nomeFornecedor;
    private String numDocumento;
    private String numRessarcimento;
    private int parcela;
    private String tipoDespesa;
    private String tipoDocumento;
    private String urlDocumento;
    private Double valorDocumento;
    private Double valorGlosa;
    private Double valorLiquido;

    public GastosDeputadosDTO() {
    }

    public GastosDeputadosDTO(int ano, String cnpjCpfFornecedor, int codDocumento, int codLote, int codTipoDocumento, String dataDocumento, int mes, String nomeFornecedor, String numDocumento, String numRessarcimento, int parcela, String tipoDespesa, String tipoDocumento, String urlDocumento, Double valorDocumento, Double valorGlosa, Double valorLiquido) {
        this.ano = ano;
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
        this.codDocumento = codDocumento;
        this.codLote = codLote;
        this.codTipoDocumento = codTipoDocumento;
        this.dataDocumento = dataDocumento;
        this.mes = mes;
        this.nomeFornecedor = nomeFornecedor;
        this.numDocumento = numDocumento;
        this.numRessarcimento = numRessarcimento;
        this.parcela = parcela;
        this.tipoDespesa = tipoDespesa;
        this.tipoDocumento = tipoDocumento;
        this.urlDocumento = urlDocumento;
        this.valorDocumento = valorDocumento;
        this.valorGlosa = valorGlosa;
        this.valorLiquido = valorLiquido;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCnpjCpfFornecedor() {
        return cnpjCpfFornecedor;
    }

    public void setCnpjCpfFornecedor(String cnpjCpfFornecedor) {
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
    }

    public int getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(int codDocumento) {
        this.codDocumento = codDocumento;
    }

    public int getCodLote() {
        return codLote;
    }

    public void setCodLote(int codLote) {
        this.codLote = codLote;
    }

    public int getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(int codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNumRessarcimento() {
        return numRessarcimento;
    }

    public void setNumRessarcimento(String numRessarcimento) {
        this.numRessarcimento = numRessarcimento;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public Double getValorGlosa() {
        return valorGlosa;
    }

    public void setValorGlosa(Double valorGlosa) {
        this.valorGlosa = valorGlosa;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }
}

