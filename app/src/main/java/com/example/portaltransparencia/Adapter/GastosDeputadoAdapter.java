package com.example.portaltransparencia.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.portaltransparencia.databinding.ItemGastosDeputadoBinding;
import com.example.portaltransparencia.dto.GastosDeputadosDTO;
import java.util.ArrayList;
import java.util.List;

public class GastosDeputadoAdapter extends RecyclerView.Adapter<GastosDeputadoAdapter.GastosViewHolder> {

    private List<GastosDeputadosDTO> gastos;
    private final String TAG = "GastosAdapter";

    public GastosDeputadoAdapter() {
        this.gastos = new ArrayList<>();
        Log.d(TAG, "Adapter inicializado");
    }

    @NonNull
    @Override
    public GastosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder chamado");
        ItemGastosDeputadoBinding binding = ItemGastosDeputadoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GastosViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GastosViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder chamado para posição: " + position);
        GastosDeputadosDTO gasto = gastos.get(position);
        holder.binding.tvAno.setText(String.valueOf(gasto.getAno()));
        holder.binding.tvMes.setText(String.valueOf(gasto.getMes()));
        holder.binding.tvValorDocumento.setText(String.format("%.2f", gasto.getValorDocumento()));
        holder.binding.tvNomeFornecedor.setText(gasto.getNomeFornecedor());
        holder.binding.tvCNPJFornecedor.setText(gasto.getCnpjCpfFornecedor());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount chamado, total de itens: " + gastos.size());
        return gastos.size();
    }

    static class GastosViewHolder extends RecyclerView.ViewHolder {
        final ItemGastosDeputadoBinding binding;

        GastosViewHolder(ItemGastosDeputadoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setGastos(List<GastosDeputadosDTO> gastos) {
        Log.d(TAG, "setGastos chamado");
        if (gastos != null) {
            this.gastos = gastos;
            Log.d(TAG, "Lista de gastos atualizada, tamanho: " + gastos.size());
        } else {
            this.gastos.clear();
            Log.d(TAG, "Lista de gastos limpa");
        }
        notifyDataSetChanged();
    }
}
