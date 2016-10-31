package com.example.brain.crudlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private OpenDB conexao;

    public UsuarioDAO(Context ctx) {

        this.conexao = new OpenDB(ctx);
    }

    public void inserirUser(Usuario usuario){

        SQLiteDatabase db = conexao.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("senha", usuario.getSenha());
        valores.put("cpf", usuario.getCpf());
        valores.put("telefone", usuario.getTelefone());
        valores.put("dataNascimento", usuario.getDataNascimento());

        db.insert("users", null, valores);
        db.close();

        Log.d("DB", "Insert Sucess");
    }
//
//    public void updateUser(int idUser, String newName, String newCpf){
////        SQLiteDatabase db = conexao.getWritableDatabase();
////
////        ContentValues valores = new ContentValues();
////        valores.put("name", newName);
////        valores.put("cpf", newCpf);
////
////        db.update("users", valores, "_id=?", new String[]{String.valueOf(idUser)});
////        db.close();
//    }
//
//    public void deleteUser(int idUser){
////        SQLiteDatabase db = conexao.getWritableDatabase();
////
////        db.delete("users", "_id=?", new String[]{String.valueOf(idUser)});
////        db.close();
//    }
//
    public List<Usuario> getAllUsers(){
        SQLiteDatabase db = conexao.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{}, null, null, null, null, null);

        String nome, senha, cpf, telefone, dataNascimento;
        int id;

        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {

            id = cursor.getInt(cursor.getColumnIndex("id"));
            nome = cursor.getString(cursor.getColumnIndex("nome"));
            senha = cursor.getString(cursor.getColumnIndex("senha"));
            cpf = cursor.getString(cursor.getColumnIndex("cpf"));
            telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));


            Usuario user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);

            listaUsuario.add(user);


        }

        db.close();

        return listaUsuario;

    }
}