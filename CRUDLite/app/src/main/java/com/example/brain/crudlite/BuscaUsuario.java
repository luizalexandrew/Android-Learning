package com.example.brain.crudlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BuscaUsuario extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_usuario);

        Intent it = getIntent();

        try{
            if (it != null) {

                Bundle param = it.getExtras();

                if (param != null){

                    String nome = param.get("usuario").toString();

                    UsuarioDAO userDao = new UsuarioDAO(BuscaUsuario.this);

                    user = userDao.getByName(nome);

                    TextView Bid = (TextView) findViewById(R.id.Bid);
                    TextView Bnome = (TextView) findViewById(R.id.Bnome);
                    TextView Bdata = (TextView) findViewById(R.id.Bnascimento);
                    TextView Bcpf = (TextView) findViewById(R.id.Bcpf);

                    Bid.setText(String.valueOf(user.getId()));
                    Bnome.setText(user.getNome());
                    Bdata.setText(user.getDataNascimento());
                    Bcpf.setText(user.getCpf());
                }

            }
        }catch (Exception e){
            finish();
        }
    }

    public void sair(View v){
        finish();
    }
}
