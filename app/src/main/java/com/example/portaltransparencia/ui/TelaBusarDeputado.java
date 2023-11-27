package com.example.portaltransparencia.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.portaltransparencia.Adapter.DeputadoAdapter;
import com.example.portaltransparencia.R;
import com.example.portaltransparencia.Retrofit.RetrofitConfig;
import com.example.portaltransparencia.databinding.ActivityTelaBusarDeputadoBinding;
import com.example.portaltransparencia.dto.DeputadoDTO;
import com.example.portaltransparencia.dto.RespostaDeputadosDTO;
import com.example.portaltransparencia.service.ApiDeputado;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TelaBusarDeputado extends AppCompatActivity {

    private ActivityTelaBusarDeputadoBinding binding;
    private ApiDeputado apiDeputado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaBusarDeputadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuração do RecyclerView
        binding.listaDeputados.setLayoutManager(new LinearLayoutManager(this));
        binding.listaDeputados.setAdapter(new DeputadoAdapter(new ArrayList<>()));

        apiDeputado = new RetrofitConfig().getDeputados();
        binding.btnBuscar.setOnClickListener(v -> {
            String nomeDeputado = binding.edNomeDeputado.getText().toString();
            String nomePartido = binding.edNomePartido.getText().toString();
            String siglaUF = binding.edUF.getText().toString();
            Log.d("TelaBusarDeputado", "Parâmetros - Nome: " + nomeDeputado + ", Partido: " + nomePartido + ", UF: " + siglaUF);
            buscarDeputados(nomeDeputado, nomePartido, siglaUF);
        });
    }


    private void buscarDeputados(String nomeDeputado, String nomePartido,  String siglaUF) {
        String urlChamada = apiDeputado.getDeputados(nomeDeputado, nomePartido, siglaUF).request().url().toString();
        Log.d("TelaBusarDeputado", "URL da chamada: " + urlChamada);


        apiDeputado.getDeputados(nomeDeputado, nomePartido, siglaUF).enqueue(new Callback<RespostaDeputadosDTO>() {
            @Override
            public void onResponse(Call<RespostaDeputadosDTO> call, Response<RespostaDeputadosDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    atualizarListaDeputados(response.body().getDados());
                //    atualizarTextViewComResposta(response.body().toString());
                } else {
                  //  atualizarTextViewComResposta("Falha na resposta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<RespostaDeputadosDTO> call, Throwable t) {
                atualizarTextViewComResposta("Erro na chamada da API: " + t.getMessage());
                Log.e("TelaBuscDeputado:", "Erro na chamada da API: " + t.getMessage());
            }

        });
    }



    private void atualizarListaDeputados(List<DeputadoDTO> listaDeputados) {
        DeputadoAdapter adapter = (DeputadoAdapter) binding.listaDeputados.getAdapter();
        if (adapter != null) {
            adapter.setDeputados(listaDeputados);
            adapter.notifyDataSetChanged();
        } else {
            Log.e("TelaBusarDeputado", "Adapter é null");
        }
    }


    private void atualizarTextViewComResposta(String resposta) {
        binding.tvApiResponse.setText(resposta);
    }




}