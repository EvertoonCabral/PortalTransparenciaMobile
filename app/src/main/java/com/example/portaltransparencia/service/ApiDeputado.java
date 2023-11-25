package com.example.portaltransparencia.service;

import com.example.portaltransparencia.dto.DeputadoDTO;
import com.example.portaltransparencia.dto.RespostaDeputadosDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiDeputado {


        @Headers("Accept: application/json")
        @GET("/deputados")
        Call<RespostaDeputadosDTO> getDeputados(@Query("nome") String nome,
                                                @Query("siglaPartido") String siglaPartido,
                                                @Query("siglaUf") String siglaUf);


    /*
    @GET("/deputados/{id}")
    Call<DeputadoDetalheDTO> getDetalhesDeputado(@Path("id") long id);


    @GET("/deputados/{id}/despesas")
    Call<List<DespesaDTO>> getDespesasDeputado(@Path("id") long id);


     */


}
