package com.example.portaltransparencia.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.portaltransparencia.databinding.ItemDeputadoBinding;
import com.example.portaltransparencia.dto.DeputadoDTO;
import java.util.List;

public class DeputadoAdapter extends RecyclerView.Adapter<DeputadoAdapter.DeputadoViewHolder> {

    private List<DeputadoDTO> deputados;

    public DeputadoAdapter(List<DeputadoDTO> deputados) {
        this.deputados = deputados;
    }

    @NonNull
    @Override
    public DeputadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDeputadoBinding binding = ItemDeputadoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DeputadoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeputadoViewHolder holder, int position) {
        DeputadoDTO deputado = deputados.get(position);
        holder.binding.tvIdDeputado.setText(String.valueOf(deputado.getId()));
        holder.binding.tvNomeDeputado.setText(deputado.getNome());
        holder.binding.tvSiglaPartido.setText(deputado.getSiglaPartido());
        holder.binding.tvSiglaUf.setText(deputado.getSiglaUf());
    }

    @Override
    public int getItemCount() {
        return deputados.size();
    }

    static class DeputadoViewHolder extends RecyclerView.ViewHolder {
        final ItemDeputadoBinding binding;

        DeputadoViewHolder(ItemDeputadoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setDeputados(List<DeputadoDTO> deputados) {
        this.deputados = deputados;
    }

}
