package com.example.portaltransparencia.service;

import com.example.portaltransparencia.dto.PartidosResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiPartido {

    @GET("partidos")
    Call<PartidosResponseDTO> obterPartidos(@Query("sigla") String siglaPartido);
}
