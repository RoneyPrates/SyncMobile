package com.example.syncmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OrdemAdapter extends ArrayAdapter<Ordem> {

    public OrdemAdapter(Context context, List<Ordem> ordens) {
        super(context, 0, ordens);
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

        numeroOrdemTextView.setText(ordem.getId());
        dataOrdemTextView.setText(ordem.getDataOrdem());
        valorOrdemTextView.setText(String.valueOf(ordem.getValorOrdem()));
        nomeUsuarioTextView.setText(ordem.getNomeUsuario());
        observacaoTextView.setText(ordem.getObservacao());

        statusOrdemTextView.setText(ordem.getStatus());
        switch (ordem.getStatus()) {
            case "Aprovada":
                statusOrdemTextView.setTextColor(getContext().getResources().getColor(android.R.color.holo_green_dark));
                break;
            case "Reprovada":
                statusOrdemTextView.setTextColor(getContext().getResources().getColor(android.R.color.holo_red_dark));
                break;
            case "Pendente":
                statusOrdemTextView.setTextColor(getContext().getResources().getColor(android.R.color.holo_orange_dark));
                break;
            case "Finalizada":
                statusOrdemTextView.setTextColor(getContext().getResources().getColor(android.R.color.holo_blue_dark));
                break;
            default:
                statusOrdemTextView.setTextColor(getContext().getResources().getColor(android.R.color.black));
                break;
        }

        return convertView;
    }
}
