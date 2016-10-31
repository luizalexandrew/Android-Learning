package com.example.brain.crudlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toCadastro(View v){

        Intent it = new Intent(MainActivity.this, Cadastro.class);
        startActivity(it);

    }

    public void login(View v){

        EditText edtUsuario = (EditText) findViewById(R.id.usuarioL);
        EditText edtSenha = (EditText) findViewById(R.id.senhaL);

        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        UsuarioDAO daoUsuario = new UsuarioDAO(MainActivity.this);
        Usuario user = daoUsuario.login(usuario, senha);

        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        if(user != null) {
            Intent it = new Intent(MainActivity.this, Logado.class);


            Bundle dados = new Bundle();

            dados.putString("id", String.valueOf(user.getId()));
            it.putExtras(dados);
            startActivity(it);
        }else{
            String texto = "Usuário ou senha incorretas";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }

    }


}





