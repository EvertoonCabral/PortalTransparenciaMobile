package com.example.portaltransparencia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespondeGastosDeputadoDTO {

    private Data dados; // Use a classe interna Data

    public RespondeGastosDeputadoDTO(Data dados) {
        this.dados = dados;
    }

    public RespondeGastosDeputadoDTO() {
    }

    public Data getDados() {
        return dados;
    }

    public void setDados(Data dados) {
        this.dados = dados;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        private List<GastosDeputadosDTO> gastos; // Lista de gastos


        private Integer id;


        public List<GastosDeputadosDTO> getGastos() {
            return gastos;
        }

        public void setGastos(List<GastosDeputadosDTO> gastos) {
            this.gastos = gastos;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
