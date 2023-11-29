package com.example.portaltransparencia.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.portaltransparencia.Adapter.GastosDeputadoAdapter;
import com.example.portaltransparencia.databinding.ActivityTelaBuscarPartidosBinding;
import com.example.portaltransparencia.dto.PartidoDTO;
import com.example.portaltransparencia.dto.PartidosResponseDTO;
import com.example.portaltransparencia.service.ApiPartido;
import com.example.portaltransparencia.Retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaBuscarPartidos extends AppCompatActivity {

    private ActivityTelaBuscarPartidosBinding binding;
    private ApiPartido apiPartidos;
    private GastosDeputadoAdapter.PartidoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaBuscarPartidosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiPartidos = RetrofitConfig.GET_PARTIDOS();

        setupRecyclerView();
        setupButton();
    }

    private void setupRecyclerView() {
        adapter = new GastosDeputadoAdapter.PartidoAdapter(new ArrayList<>()); // Inicializa com uma lista vazia
        binding.recyclerViewPartidos.setAdapter(adapter);
        binding.recyclerViewPartidos.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupButton() {
        binding.btnBuscar.setOnClickListener(v -> {
            String sigla = binding.EditTextPartidos.getText().toString();
            buscarPartido(sigla);
        });
    }

    private void buscarPartido(String sigla) {
        Call<PartidosResponseDTO> call = apiPartidos.getPartidos(sigla);
        call.enqueue(new Callback<PartidosResponseDTO>() {
            @Override
            public void onResponse(Call<PartidosResponseDTO> call, Response<PartidosResponseDTO> response) {
                if (response.isSuccessful()) {
                    List<PartidoDTO> partidos = response.body().getDados();
                    adapter = new GastosDeputadoAdapter.PartidoAdapter(partidos);
                    binding.recyclerViewPartidos.setAdapter(adapter);
                } else {
                    Toast.makeText(TelaBuscarPartidos.this, "Erro ao buscar informações dos partidos.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartidosResponseDTO> call, Throwable t) {
                Log.e("TelaBuscarPartidos", t.getMessage());
                Toast.makeText(TelaBuscarPartidos.this, "Falha na comunicação com a API. Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}