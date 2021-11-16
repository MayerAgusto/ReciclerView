package com.example.reciclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<Paises> paises;
    private Context context;

    public Adaptador(List<Paises> paises, MainActivity activity){
        this.paises = paises;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pais, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paises pais = paises.get(position);
        holder.nombre.setText(pais.nombre);
        holder.capital.setText(pais.capital);
        holder.poblacion.setText(pais.poblacion);
        holder.imagen.setImageResource(pais.bandera);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CountryActivity.class);
                intent.putExtra("bandera", pais.bandera);
                intent.putExtra("nombre", pais.nombre);
                intent.putExtra("capital", pais.capital);
                intent.putExtra("poblacion", pais.poblacion);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public void filterItem(List<Paises> countries) {
        paises = countries;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre,capital, poblacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.nombre);
            capital = itemView.findViewById(R.id.capital);
            poblacion = itemView.findViewById(R.id.poblacion);
        }
    }
}
