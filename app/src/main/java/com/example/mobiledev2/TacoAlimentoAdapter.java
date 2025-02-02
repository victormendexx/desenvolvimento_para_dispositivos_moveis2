package com.example.mobiledev2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TacoAlimentoAdapter extends RecyclerView.Adapter<TacoAlimentoAdapter.AlimentoViewHolder> {
    private List<TacoAlimento> listTacoAlimentos;

    public TacoAlimentoAdapter(List<TacoAlimento> listTacoAlimentos){
        this.listTacoAlimentos = listTacoAlimentos;
    }

    @NonNull
    @Override
    public AlimentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alimento, parent, false);
        return new AlimentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlimentoViewHolder holder, int position) {
        TacoAlimento tacoAlimento = listTacoAlimentos.get(position);
        holder.tvNome.setText(tacoAlimento.getNome());
        holder.tvCaloria.setText(String.valueOf(tacoAlimento.getCaloria() + " kcal"));
    }

    @Override
    public int getItemCount() {
        return listTacoAlimentos.size();
    }

    public void filtrarLista(List<TacoAlimento> listaFiltrada) {
        this.listTacoAlimentos = listaFiltrada;
        notifyDataSetChanged();
    }

    static class AlimentoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvCaloria;

        public AlimentoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvCaloria = itemView.findViewById(R.id.tvCaloria);
        }
    }
}
