package com.example.portaltransparencia.dto;

import java.util.List;

public class PartidosResponseDTO {

    private List<PartidoDTO> dados;

    public List<PartidoDTO> getDados() {
        return dados;
    }


    public PartidosResponseDTO(List<PartidoDTO> dados) {
        this.dados = dados;
    }

    public PartidosResponseDTO() {
    }

    public void setDados(List<PartidoDTO> dados) {
        this.dados = dados;
    }
}
