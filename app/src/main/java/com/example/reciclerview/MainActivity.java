package com.example.reciclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText buscador;
    List<Paises> paises;
    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscador = findViewById(R.id.search);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filtrar(editable.toString());
            }
        });

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        paises = new ArrayList<Paises>();
        paises.add(new Paises(R.drawable.pe,"Peru", "Lima","33 M"));
        paises.add(new Paises(R.drawable.co, "Colombia","Bogota","50 M"));
        paises.add(new Paises(R.drawable.cl, "Chile", "Santiago","19 M"));
        paises.add(new Paises(R.drawable.mf, "Francia","Paris","67 M"));
        paises.add(new Paises(R.drawable.us, "Estados Unidos", "Washinton","329 M"));

        adaptador = new Adaptador(paises, this);
        recycler.setAdapter(adaptador);
    }
    private void filtrar(String s){
        List<Paises> paisesFiltrados = new ArrayList<Paises>();
        for(Paises pais: paises){
            if(pais.nombre.toLowerCase().contains(s.toLowerCase())){
                paisesFiltrados.add(pais);
            }
        }
        adaptador.filterItem(paisesFiltrados);
    }
}