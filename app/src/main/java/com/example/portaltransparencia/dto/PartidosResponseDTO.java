package com.example.portaltransparencia.dto;

import java.util.List;

public class PartidosResponseDTO {


    private List<LinkPartidoDTO> links;

    private List<PartidoDTO> dados;


    public List<PartidoDTO> getDados() {
        return dados;
    }

    public List<LinkPartidoDTO> getLinks() {
        return links;
    }
}
