package com.example.percy.reto3_mobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.percy.reto3_mobile.models.Coinmarket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by percy on 21/02/18.
 */

public class AdapterDatos  extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos>{

    List<Coinmarket> listDatos;

    public AdapterDatos(List<Coinmarket> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.dato.setText(listDatos.get(position).getId());
        holder.nameBickoint.setText(listDatos.get(position).getName());
        holder.nameSymbol.setText(listDatos.get(position).getSymbol());
        holder.percent_change_24h.setText(listDatos.get(position).getPercent_change_24h());
        holder.percent_change_7h.setText(listDatos.get(position).getPercent_change_7d());
        holder.price_usd.setText(listDatos.get(position).getPrice_usd());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void addItem(List<Coinmarket> mainDataJsonResponse) {
        listDatos.addAll(mainDataJsonResponse);
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato,nameBickoint,nameSymbol,percent_change_24h,percent_change_7h,price_usd;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.idDato);
            nameBickoint = (TextView) itemView.findViewById(R.id.nameBickoint);
            nameSymbol = (TextView) itemView.findViewById(R.id.nameSymbol);
            percent_change_24h = (TextView) itemView.findViewById(R.id.percent_change_24h);
            percent_change_7h = (TextView) itemView.findViewById(R.id.percent_change_7h);
            price_usd = (TextView) itemView.findViewById(R.id.price_usd);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);

        }
    }
}
