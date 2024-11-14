package com.example.syncmobile;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrdemAdapter extends ArrayAdapter<Ordem> {

    private List<Ordem> ordensFiltradas;
    private List<Ordem> ordensOriginais;

    public OrdemAdapter(Context context, List<Ordem> ordens) {
        super(context, 0, ordens);
        this.ordensOriginais = new ArrayList<>();
        this.ordensFiltradas = new ArrayList<>();

        for (Ordem ordem : ordens) {
            if (!"Deletada".equals(ordem.getStatus())) {
                ordensOriginais.add(ordem);
                ordensFiltradas.add(ordem);
            }
        }
        addAll(ordensFiltradas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ordem ordem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_ordem, parent, false);
        }

        TextView numeroOrdemTextView = convertView.findViewById(R.id.numeroOrdem);
        TextView dataOrdemTextView = convertView.findViewById(R.id.dataOrdem);
        TextView valorOrdemTextView = convertView.findViewById(R.id.valorOrdem);
        TextView statusOrdemTextView = convertView.findViewById(R.id.statusOrdem);
        TextView nomeUsuarioTextView = convertView.findViewById(R.id.nomeUsuario);
        TextView observacaoTextView = convertView.findViewById(R.id.observacao);

        numeroOrdemTextView.setText("Número da Ordem: " + ordem.getId());
        dataOrdemTextView.setText("Data da Ordem: " + ordem.getDataOrdem());
        valorOrdemTextView.setText("Valor da Ordem: " + ordem.getValorOrdem());
        nomeUsuarioTextView.setText("Nome do Usuário: " + ordem.getNomeUsuario());
        observacaoTextView.setText("Observação: " + ordem.getObservacao());
        statusOrdemTextView.setText("Status da Ordem: " + ordem.getStatus());

        int borderColor;
        int statusColor;
        switch (ordem.getStatus()) {
            case "Compra Aprovada":
                borderColor = android.R.color.holo_green_dark;
                statusColor = borderColor;
                break;
            case "Compra Efetuada":
                borderColor = android.R.color.holo_green_light;
                statusColor = borderColor;
                break;
            case "Reprovada":
                borderColor = android.R.color.holo_red_dark;
                statusColor = borderColor;
                break;
            case "Pendente":
                borderColor = android.R.color.holo_orange_dark;
                statusColor = borderColor;
                break;
            case "Finalizada":
                borderColor = android.R.color.holo_blue_dark;
                statusColor = borderColor;
                break;
            default:
                borderColor = android.R.color.transparent;
                statusColor = android.R.color.transparent;
                break;
        }

        GradientDrawable drawable = (GradientDrawable) convertView.getBackground();
        drawable.setStroke(10, getContext().getResources().getColor(borderColor));
        statusOrdemTextView.setTextColor(getContext().getResources().getColor(statusColor));

        return convertView;
    }

    public void filtrarOrdens(String query) {
        ordensFiltradas.clear();

        if (query.isEmpty()) {
            ordensFiltradas.addAll(ordensOriginais);
        } else {
            for (Ordem ordem : ordensOriginais) {
                if (String.valueOf(ordem.getId()).contains(query)) {
                    ordensFiltradas.add(ordem);
                }
            }
        }

        clear();
        addAll(ordensFiltradas);
        notifyDataSetChanged();
    }
}
