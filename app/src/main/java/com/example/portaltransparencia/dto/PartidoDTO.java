package com.example.portaltransparencia.dto;

public class PartidoDTO {


    private Long id;
    private String sigla;
    private String nome;
    private String uri;

    public PartidoDTO() {
    }
    public PartidoDTO(Long id, String sigla, String nome, String uri) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
