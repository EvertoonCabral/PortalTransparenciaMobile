package com.example.portaltransparencia.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.portaltransparencia.Adapter.DeputadoAdapter;
import com.example.portaltransparencia.Adapter.GastosDeputadoAdapter;
import com.example.portaltransparencia.R;
import com.example.portaltransparencia.Retrofit.RetrofitConfig;
import com.example.portaltransparencia.databinding.ActivityTelaBusarDeputadoBinding;
import com.example.portaltransparencia.dto.DeputadoDTO;
import com.example.portaltransparencia.dto.GastosDeputadosDTO;
import com.example.portaltransparencia.dto.RespondeGastosDeputadoDTO;
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

    private ApiDeputado apiGastosDeputado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaBusarDeputadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuração do RecyclerView para Deputados
        binding.listaDeputados.setLayoutManager(new LinearLayoutManager(this));
        binding.listaDeputados.setAdapter(new DeputadoAdapter(new ArrayList<>()));

        // Configuração do RecyclerView para Gastos
        binding.listaGastos.setLayoutManager(new LinearLayoutManager(this));
        binding.listaGastos.setAdapter(new GastosDeputadoAdapter());

        apiDeputado = new RetrofitConfig().getDeputados();
        apiGastosDeputado = new RetrofitConfig().getGastosDeputado();

        binding.btnBuscar.setOnClickListener(v -> {
            String nomeDeputado = binding.edNomeDeputado.getText().toString();
            String nomePartido = binding.edNomePartido.getText().toString();
            String siglaUF = binding.edUF.getText().toString();
            buscarDeputados(nomeDeputado, nomePartido, siglaUF);
            Log.d("TelaBusarDeputado", "Buscando deputados...");

        });

        binding.btnGastosDeputado.setOnClickListener(v -> {
            String idDeputado = binding.idDeputadoGastos.getText().toString();
            if (!idDeputado.isEmpty()) {
                buscarGastosDeputado(Long.parseLong(idDeputado));
                Log.d("TelaBusarDeputado", "Buscando gastos do deputado...");

            }
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
                Log.e("TelaBuscDeputado:", "Erro na chamada da API: " + t.getMessage());
            }

        });
    }



    private void atualizarListaDeputados(List<DeputadoDTO> listaDeputados) {
        DeputadoAdapter adapter = (DeputadoAdapter) binding.listaDeputados.getAdapter();
        if (adapter != null) {
            adapter.setDeputados(listaDeputados);
            adapter.notifyDataSetChanged();
            Log.d("TelaBusarDeputado", "Lista de deputados atualizada.");

        } else {
            Log.e("TelaBusarDeputado", "Adapter é null");
        }
    }



    private void buscarGastosDeputado(long idDeputado) {
        Log.d("TelaBusarDeputado", "Iniciando busca dos gastos do deputado ID: " + idDeputado);
        apiGastosDeputado.getGastosDeputado(idDeputado).enqueue(new Callback<RespondeGastosDeputadoDTO>() {
            @Override
            public void onResponse(Call<RespondeGastosDeputadoDTO> call, Response<RespondeGastosDeputadoDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("TelaBusarDeputado", "Resposta recebida: " + response.body().toString());
                    atualizarListaGastos(response.body().getDados().getGastos());
                    binding.listaDeputados.setVisibility(View.GONE); // Oculta a lista de deputados
                    binding.listaGastos.setVisibility(View.VISIBLE); // Mostra a lista de gastos
                } else {
                    Log.e("TelaBusarDeputado", "Falha na resposta dos gastos: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<RespondeGastosDeputadoDTO> call, Throwable t) {
                Log.e("TelaBusarDeputado", "Erro na chamada da API dos gastos: " + t.getMessage());
            }
        });
    }

    private void atualizarListaGastos(List<GastosDeputadosDTO> listaGastos) {
        Log.d("TelaBusarDeputado", "Atualizando lista de gastos. Tamanho: " + listaGastos.size());
        GastosDeputadoAdapter adapter = (GastosDeputadoAdapter) binding.listaGastos.getAdapter();
        if (adapter != null) {
            adapter.setGastos(listaGastos);
            adapter.notifyDataSetChanged();
        } else {
            Log.e("TelaBusarDeputado", "Adapter de gastos é null");
        }
    }





}