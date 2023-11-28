package com.example.portaltransparencia.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.portaltransparencia.api.ApiPartidos;
import com.example.portaltransparencia.dto.PartidosDTO;
import com.example.portaltransparencia.dto.PartidosResponseDTO;
import com.example.portaltransparencia.service.ApiPartido;
import com.example.portaltransparencia.service.RetrofitService;
import com.example.portaltransparencia.databinding.ActivityTelaBuscarPartidoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaBuscarPartido extends AppCompatActivity {

    private ActivityTelaBuscarPartidoBinding binding;
    private ApiPartido apiPartidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaBuscarPartidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiPartidos = RetrofitService.getRetrofitInstance().create(ApiPartido.class);

        setupSpinner();
        setupButton();
    }

    private void setupSpinner() {
        List<String> siglas = obterSiglasDosPartidos();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, siglas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spSiglaPartido.setAdapter(adapter);
    }

    private void setupButton() {
        binding.btBuscar.setOnClickListener(v -> {
            String sigla = binding.spSiglaPartido.getSelectedItem().toString();
            buscarPartido(sigla);
        });
    }

    private void buscarPartido(String sigla) {
        Call<PartidosResponseDTO> call = apiPartidos.obterPartidoPorSigla(sigla);
        call.enqueue(new Callback<PartidosResponseDTO>() {
            @Override
            public void onResponse(Call<PartidosResponseDTO> call, Response<PartidosResponseDTO> response) {
                if (response.isSuccessful()) {
                    PartidosDTO partido = response.body().getDados().get(0);
                    exibirInfoPartido(partido);
                } else {
                    Toast.makeText(TelaBuscarPartido.this, "Erro ao buscar informações do partido.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartidosResponseDTO> call, Throwable t) {
                Toast.makeText(TelaBuscarPartido.this, "Falha na comunicação com a API.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exibirInfoPartido(PartidosDTO partido) {
        String info = "Sigla: " + partido.getSigla() + "\nNome: " + partido.getNome();
        binding.txtInfoPartido.setText(info);
    }

    private List<String> obterSiglasDosPartidos() {
        // Implemente a lógica para obter as siglas dos partidos
        return null;
    }
}
