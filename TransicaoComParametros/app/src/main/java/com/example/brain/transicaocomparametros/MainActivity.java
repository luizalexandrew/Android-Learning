package com.example.brain.transicaocomparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = (Button) findViewById(R.id.Botao);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nome = (EditText) findViewById(R.id.nome);
                EditText senha = (EditText) findViewById(R.id.senha);

                String nomeUsuario = nome.getText().toString();
                String senhaUsuario = senha.getText().toString();

                Intent it = new Intent(MainActivity.this, Resposta.class);

                Bundle params = new Bundle();

                params.putString("nome", nomeUsuario);
                params.putString("senha", senhaUsuario);

                it.putExtras(params);
                startActivity(it);

            }
        });





    }
}
