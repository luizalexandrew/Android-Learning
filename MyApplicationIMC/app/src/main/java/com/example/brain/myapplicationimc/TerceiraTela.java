package com.example.brain.myapplicationimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class TerceiraTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        Intent it = getIntent();
        String imc, categoria;

        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {

                imc = params.getString("imc").toString();
                categoria = params.getString("categoria").toString();

                TextView textImc = (TextView) findViewById(R.id.resultadoIMC);
                TextView textCategoria = (TextView) findViewById(R.id.resultadoCategoria);

                Log.d("[Categoria]", categoria);
                Log.d("[IMC BIRRR]", imc);

                textImc.setText(imc);
                textCategoria.setText(categoria);

            }
        }



    }



}
