package com.example.portaltransparencia.dto;

public class DeputadoDTO {


    private String id;

    private String uri;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
    private String idLegislatura;

    private String urlFoto;
    private String email;

    private String uriPartido;


    public DeputadoDTO() {
    }

    public DeputadoDTO(String id, String uri, String nome, String siglaPartido, String siglaUf, String idLegislatura, String urlFoto, String email, String uriPartido) {
        this.id = id;
        this.uri = uri;
        this.nome = nome;
        this.siglaPartido = siglaPartido;
        this.siglaUf = siglaUf;
        this.idLegislatura = idLegislatura;
        this.urlFoto = urlFoto;
        this.email = email;
        this.uriPartido = uriPartido;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(String idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    @Override
    public String toString() {
        return "DeputadoDTO{" +
                "id='" + id + '\'' +
                ", uri='" + uri + '\'' +
                ", nome='" + nome + '\'' +
                ", siglaPartido='" + siglaPartido + '\'' +
                ", siglaUf='" + siglaUf + '\'' +
                ", idLegislatura='" + idLegislatura + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", email='" + email + '\'' +
                ", uriPartido='" + uriPartido + '\'' +
                '}';
    }
}
