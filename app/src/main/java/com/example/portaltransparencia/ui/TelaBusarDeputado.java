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

            apiDeputado = new RetrofitConfig().getDeputados();
            apiGastosDeputado = new RetrofitConfig().getGastosDeputado();

            binding.btnBuscar.setOnClickListener(v -> {
                String nomeDeputado = binding.edNomeDeputado.getText().toString();
                String nomePartido = binding.edNomePartido.getText().toString();
                String siglaUF = binding.edUF.getText().toString();
                buscarDeputados(nomeDeputado, nomePartido, siglaUF);
            });

            binding.btnGastosDeputado.setOnClickListener(v -> {
                String idDeputado = binding.idDeputadoGastos.getText().toString();
                if (!idDeputado.isEmpty()) {
                    buscarGastosDeputado(Long.parseLong(idDeputado));
                }
            });
        }

        private void buscarDeputados(String nomeDeputado, String nomePartido, String siglaUF) {
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
        Log.d("TelaBusarDeputado", "Iniciando busca de gastos do deputado com ID: " + idDeputado);
        apiGastosDeputado.getGastosDeputado(idDeputado).enqueue(new Callback<RespondeGastosDeputadoDTO>() {
            @Override
            public void onResponse(Call<RespondeGastosDeputadoDTO> call, Response<RespondeGastosDeputadoDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("TelaBusarDeputado", "Resposta bem-sucedida da API de gastos.");
                    List<GastosDeputadosDTO> gastos = response.body().getDados();
                    exibirGastos(gastos);
                } else {
                    Log.e("TelaBusarDeputado", "Falha na resposta dos gastos. Código: " + response.code());
                    if (response.errorBody() != null) {
                        try {
                            Log.e("TelaBusarDeputado", "Erro na resposta dos gastos: " + response.errorBody().string());
                        } catch (Exception e) {
                            Log.e("TelaBusarDeputado", "Erro ao obter o corpo de erro da resposta dos gastos", e);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<RespondeGastosDeputadoDTO> call, Throwable t) {
                Log.e("TelaBusarDeputado", "Erro na chamada da API dos gastos.", t);
            }
        });
    }

    private void exibirGastos(List<GastosDeputadosDTO> gastos) {
        StringBuilder gastosTexto = new StringBuilder();
        for (GastosDeputadosDTO gasto : gastos) {
            // Formatar e adicionar cada gasto ao StringBuilder
            gastosTexto.append("Ano: ").append(gasto.getAno())
                    .append("\nValor: ").append(gasto.getValorDocumento())
                    .append("\nFornecedor: ").append(gasto.getNomeFornecedor())
                    .append("\n\n");
        }

        binding.txtExibirGastos.setText(gastosTexto.toString());
    }


    }


