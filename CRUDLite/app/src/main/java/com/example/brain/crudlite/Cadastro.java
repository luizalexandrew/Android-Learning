package com.example.brain.crudlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import static java.lang.Integer.*;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void voltarLogin(View v){
        finish();
    }

    public void cadastrar(View v){

        EditText etName = (EditText) findViewById(R.id.campoNome);
        EditText etSenha = (EditText) findViewById(R.id.campoSenha);
        EditText etTelefone = (EditText) findViewById(R.id.campoTelefone);
        EditText etDataNascimento = (EditText) findViewById(R.id.campoData);
        EditText etCPF = (EditText) findViewById(R.id.campoCPF);

        String nome = etName.getText().toString();
        String senha = etSenha.getText().toString();
        String telefone = etTelefone.getText().toString();
        String cpf = etCPF.getText().toString();
        String dataNascimento = etDataNascimento.getText().toString();

        Usuario usuario = new Usuario(nome, senha, cpf, telefone, dataNascimento);

        UsuarioDAO daoUsuario = new UsuarioDAO(Cadastro.this);

        int cadastro = daoUsuario.inserirUser(usuario);

        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        if(cadastro == 1){
            String texto = "Sucesso ao cadastrar";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
            finish();
        }else{
            String texto = "Falha no cadastro";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }

    }



}
