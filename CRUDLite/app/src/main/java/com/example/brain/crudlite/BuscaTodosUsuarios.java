package com.example.brain.crudlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.brain.crudlite.R.id.listaUsuarioBIR;

public class BuscaTodosUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_todos_usuarios);

        UsuarioDAO daoUsuario = new UsuarioDAO(BuscaTodosUsuarios.this);

        ArrayList<Usuario> listUser = (ArrayList<Usuario>) daoUsuario.getAllUsers();

        ArrayList<String> nomeUsuarios = new ArrayList<String>();

        for (Usuario usuario : listUser) {
            nomeUsuarios.add("ID: " + usuario.getId() + "\nUsuário:" + usuario.getNome() + "\nCPF: " + usuario.getCpf() + "\n" + usuario.getDataNascimento() + "\n"  + usuario.getTelefone());
        }



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nomeUsuarios);

        ListView lv = (ListView) findViewById(listaUsuarioBIR);
        lv.setAdapter(adapter);

    }

    public void sair(View v){
        finish();
    }
}
