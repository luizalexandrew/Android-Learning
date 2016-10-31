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

    public int inserirUser(Usuario usuario){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nome", usuario.getNome());
            valores.put("senha", usuario.getSenha());
            valores.put("cpf", usuario.getCpf());
            valores.put("telefone", usuario.getTelefone());
            valores.put("dataNascimento", usuario.getDataNascimento());

            db.insert("users", null, valores);
            db.close();

            return 1;
        }catch (Exception e){
            return 0;
        }
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

    public Usuario login(String dnome, String dsenha){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "nome = ? AND senha = ?";
        String[] whereArgs = new String[] {dnome,dsenha};
        Cursor cursor = db.query("users", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, senha, cpf, telefone, dataNascimento;
        int id;
        Usuario user = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                senha = cursor.getString(cursor.getColumnIndex("senha"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));

                user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);
                db.close();
                Log.d("BIRRR", "HEHEHEHHEHEHE");
                return user;
            }
        }catch (Exception e ){

        }
        return user;


    }

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

    public Usuario getByName(String dnome){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "nome = ?";
        String[] whereArgs = new String[] {dnome};
        Cursor cursor = db.query("users", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, senha, cpf, telefone, dataNascimento;
        int id;
        Usuario user = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                senha = cursor.getString(cursor.getColumnIndex("senha"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));

                user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);
                db.close();
                Log.d("BIRRR", "HEHEHEHHEHEHE");
                return user;
            }
        }catch (Exception e ){

        }
        return user;

    }

    public Usuario getByID(String did){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs = new String[] {did};
        Cursor cursor = db.query("users", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, senha, cpf, telefone, dataNascimento;
        int id;
        Usuario user = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                senha = cursor.getString(cursor.getColumnIndex("senha"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                dataNascimento = cursor.getString(cursor.getColumnIndex("dataNascimento"));

                user = new Usuario(id, nome, senha, cpf, telefone, dataNascimento);
                db.close();
                Log.d("BIRRR", "HEHEHEHHEHEHE");
                return user;
            }
        }catch (Exception e ){

        }
        return user;

    }

    public int updateUser(int idUser, String newName, String newSenha){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues valores = new ContentValues();

            valores.put("nome", newName);
            valores.put("senha", newSenha);

            db.update("users", valores, "id=?", new String[]{String.valueOf(idUser)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    public int deleteUser(int idUser){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            db.delete("users", "id=?", new String[]{String.valueOf(idUser)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

}