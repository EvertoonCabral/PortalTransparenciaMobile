package com.example.portaltransparencia.Retrofit;

import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    public static final String BASE_URL_API = "https://dadosabertos.camara.leg.br/api/v2/";


    private static retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

}
