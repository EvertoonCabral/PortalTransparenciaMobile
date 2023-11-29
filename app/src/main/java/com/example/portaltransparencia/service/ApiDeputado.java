package com.example.portaltransparencia.service;

import com.example.portaltransparencia.dto.RespondeGastosDeputadoDTO;
import com.example.portaltransparencia.dto.RespostaDeputadosDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiDeputado {


        @GET("deputados")
        Call<RespostaDeputadosDTO> getDeputados(@Query("nome") String nome,
                                                @Query("siglaPartido") String siglaPartido,
                                                @Query("siglaUf") String siglaUf);


    @GET("deputados/{id}/despesas")
    Call<RespondeGastosDeputadoDTO> getGastosDeputado(@Path("id") long id);



}
