package com.example.brain.crudlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Logado extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);


        Intent it = getIntent();

        if (it != null) {

            Bundle param = it.getExtras();

            if (param != null){

                String id = param.get("id").toString();

                UsuarioDAO userDao = new UsuarioDAO(Logado.this);
                user = userDao.getByID(id);

                setValuesUser();

            }


        }

    }

    private void setValuesUser(){

        TextView actNome = (TextView) findViewById(R.id.apNome);
        TextView actTelefone = (TextView) findViewById(R.id.apTelefone);
        TextView actDataNascimento = (TextView) findViewById(R.id.apDataNascimento);
        TextView actCPF = (TextView) findViewById(R.id.apCPF);

        actNome.setText(this.user.getNome());
        actTelefone.setText(this.user.getTelefone());
        actDataNascimento.setText(this.user.getDataNascimento());
        actCPF.setText(this.user.getCpf());

    }

    public void atualizarDados(View v){

        TextView actNome = (TextView) findViewById(R.id.novoNome);
        TextView actSenha = (TextView) findViewById(R.id.novoSenha);

        user.setNome(actNome.getText().toString());
        user.setSenha(actSenha.getText().toString());

        UsuarioDAO userDao = new UsuarioDAO(Logado.this);

        userDao.updateUser(user.getId(), user.getNome(), user.getSenha());

        setValuesUser();


    }

    public void sair(View v){
        finish();
    }

    public void buscarUsuario(View v){

        EditText edtUserBusca = (EditText) findViewById(R.id.nomeBuscarUsuario);
        String nomeBuscaUsuario = edtUserBusca.getText().toString();

        Bundle params = new Bundle();
        params.putString("usuario", nomeBuscaUsuario);

        Intent it = new Intent(Logado.this, BuscaUsuario.class);
        it.putExtras(params);
        startActivity(it);

    }

    public void excluirConta(View v){

        UsuarioDAO userDao = new UsuarioDAO(Logado.this);
        userDao.deleteUser(user.getId());
        finish();

    }

    public void buscarTodosUsuarios(View v){

        Intent it = new Intent(Logado.this, BuscaTodosUsuarios.class);
        startActivity(it);

    }

}
