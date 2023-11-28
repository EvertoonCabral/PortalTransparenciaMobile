package com.example.portaltransparencia.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.portaltransparencia.R;
import com.example.portaltransparencia.databinding.ActivityTelaBuscarPartidosBinding;
import com.example.portaltransparencia.dto.PartidoDTO;
import com.example.portaltransparencia.dto.PartidosResponseDTO;
import com.example.portaltransparencia.service.ApiPartido;
import com.example.portaltransparencia.Retrofit.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaBuscarPartidos extends AppCompatActivity {

    private ActivityTelaBuscarPartidosBinding binding;
    private ApiPartido apiPartidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaBuscarPartidosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiPartidos = RetrofitConfig.getPartidos(); // Uso do RetrofitConfig para obter a instância da API

        setupButton();
    }

    private void setupButton() {
        binding.btnBuscar.setOnClickListener(v -> {
            EditText editTextPartidos = findViewById(R.id.EditTextPartidos);  // Atualize este ID
            String sigla = editTextPartidos.getText().toString();
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
                    // Aqui você pode atualizar o RecyclerView com os dados dos partidos
                } else {
                    Toast.makeText(TelaBuscarPartidos.this, "Erro ao buscar informações dos partidos.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartidosResponseDTO> call, Throwable t) {
                Toast.makeText(TelaBuscarPartidos.this, "Falha na comunicação com a API.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
