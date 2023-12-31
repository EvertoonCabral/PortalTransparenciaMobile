package com.example.portaltransparencia.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.portaltransparencia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBuscarDeputados.setOnClickListener(v -> abrirTelaDeputado());

        binding.btnBuscarPartidos.setOnClickListener(v ->abrirTelaPartido());

    }


    private void abrirTelaDeputado() {
        Intent intent = new Intent(this, TelaBusarDeputado.class);
        startActivity(intent);
    }


    private void abrirTelaPartido() {
        Intent intent = new Intent(this, TelaBuscarPartidos.class);
        startActivity(intent);
    }

}
