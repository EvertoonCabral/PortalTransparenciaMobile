package com.example.portaltransparencia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespondeGastosDeputadoDTO {
    private List<GastosDeputadosDTO> dados;

    public List<GastosDeputadosDTO> getDados() {
        return dados;
    }

    public void setDados(List<GastosDeputadosDTO> dados) {
        this.dados = dados;
    }
}
