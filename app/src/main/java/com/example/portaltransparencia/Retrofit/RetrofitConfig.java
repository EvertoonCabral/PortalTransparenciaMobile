package com.example.portaltransparencia.Retrofit;

import com.example.portaltransparencia.service.ApiDeputado;
import com.example.portaltransparencia.service.ApiPartido;

import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";


    private static retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();





    public static ApiDeputado getDeputados (){
        return retrofit.create(ApiDeputado.class);
    }

    public static ApiDeputado getGastosDeputado (){
        return retrofit.create(ApiDeputado.class);
    }

    public static ApiPartido getPartidos (){return  retrofit.create(ApiPartido.class);}









}
