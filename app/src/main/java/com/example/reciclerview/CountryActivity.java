package com.example.reciclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryActivity extends AppCompatActivity {
    ImageView imagen;
    TextView nombre,capital, poblacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        imagen = findViewById(R.id.dataBandera);
        nombre = findViewById(R.id.dataNombre);
        capital = findViewById(R.id.dataCapital);
        poblacion = findViewById(R.id.dataPoblacion);

        Bundle datos = this.getIntent().getExtras();
        int bandera  = datos.getInt("bandera");
        String name = datos.getString("nombre");
        String cap = datos.getString("capital");
        String people = datos.getString("poblacion");

        imagen.setImageResource(bandera);
        nombre.setText(name);
        capital.setText("Capital: "+cap);
        poblacion.setText("Poblacion"+people);
    }
}