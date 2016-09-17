package com.example.brain.transicaocomparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resposta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){

                String nomeUsuario = params.getString("nome");
                String senhaUsuario = params.getString("senha");

                TextView nome = (TextView) findViewById(R.id.resultadoNome);
                TextView senha = (TextView) findViewById(R.id.resultadoSenha);

                nome.setText(nomeUsuario);
                senha.setText(senhaUsuario);



            }
        }

    }

    public void voltarMain(View v){
        finish();
//        Intent it = new Intent(Resposta.this, MainActivity.class);
//        startActivity(it);
    }
}
