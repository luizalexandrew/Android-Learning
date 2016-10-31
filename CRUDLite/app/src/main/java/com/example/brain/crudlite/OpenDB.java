package com.example.brain.crudlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenDB extends SQLiteOpenHelper {

    private final String databaseName = "dbUser";
    private final int databaseVersion = 1;

    private final String sqlCreate = "CREATE TABLE users "+
            "(id integer primary key autoincrement, " +
            "nome text not null, senha text not null, cpf text not null " +
            ", telefone text not null, dataNascimento date not null);";
    private final String sqlUpgrade = "DROP TABLE IF EXISTS users";

    public OpenDB(Context ctx){
        super(ctx,"dbUser",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(this.sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(this.sqlUpgrade);
        onCreate(db);
    }

}