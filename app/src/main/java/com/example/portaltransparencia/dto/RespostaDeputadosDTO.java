package com.example.portaltransparencia.dto;

import java.util.List;

public class RespostaDeputadosDTO {

    private List<DeputadoDTO> dados;

    private List<LinkDTO> links;

    public RespostaDeputadosDTO(List<DeputadoDTO> dados, List<LinkDTO> links) {
        this.dados = dados;
        this.links = links;
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

    public void setLinks(List<LinkDTO> links) {
        this.links = links;
    }

    public static class LinkDTO {
        private String href;
        private String rel;
        private String type;


        public LinkDTO() {
        }

        public LinkDTO(String href, String rel, String type) {
            this.href = href;
            this.rel = rel;
            this.type = type;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


}
