package com.example.portaltransparencia.dto;

import java.util.List;

public class RespostaDeputadosDTO {

    private List<DeputadoDTO> dados;

    private List<LinkDTO> links; // Adicione esta linha



    public RespostaDeputadosDTO(List<DeputadoDTO> dados) {
        this.dados = dados;
    }

    public RespostaDeputadosDTO() {
    }

    public List<DeputadoDTO> getDados() {
        return dados;
    }

    public void setDados(List<DeputadoDTO> dados) {
        this.dados = dados;
    }

    public List<LinkDTO> getLinks() {
        return links;
    }


    @Override
    public String toString() {
        return "RespostaDeputadosDTO{" +
                "dados=" + dados +
                ", links=" + links +
                '}';
    }
}
