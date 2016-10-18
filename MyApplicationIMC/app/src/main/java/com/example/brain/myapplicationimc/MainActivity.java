package com.example.brain.myapplicationimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviardados(View v){

        EditText nome = (EditText) findViewById(R.id.nome);
        EditText telefone = (EditText) findViewById(R.id.telefone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText peso = (EditText) findViewById(R.id.peso);
        EditText altura = (EditText) findViewById(R.id.altura);

        Log.d("[teste]", nome.getText().toString());
        Log.d("[teste]", telefone.getText().toString());
        Log.d("[teste]", email.getText().toString());
        Log.d("[teste]", peso.getText().toString());
        Log.d("[teste]", altura.getText().toString());

        int COD_ACTIVITY_1 = 1;
        Intent it = new Intent(MainActivity.this, MostrarDados.class);

        Bundle dados = new Bundle();

        dados.putString("nome", nome.getText().toString());
        dados.putString("telefone", telefone.getText().toString());
        dados.putString("email", email.getText().toString());
        dados.putString("peso", peso.getText().toString());
        dados.putString("altura", altura.getText().toString());

        it.putExtras(dados);


        startActivityForResult(it, COD_ACTIVITY_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 1) {

            Bundle params = data.getExtras();
            if (params != null) {

                String imc = params.getString("imc");
                String categoria = calcularCategoria(Double.parseDouble(imc));

                Bundle dados = new Bundle();

                dados.putString("imc", imc.toString());
                dados.putString("categoria", categoria.toString());

                Intent it = new Intent(MainActivity.this, TerceiraTela.class);

                it.putExtras(dados);
                startActivity(it);







            }



        }

    }

    public String calcularCategoria(Double imc){

        if (imc < 16){
            return "Magreza grave";
        }else if(imc >=16 && imc < 17){
            return "Magreza moderada";
        }else if(imc >= 17 && imc < 18.5){
            return "Magreza leve";
        }else if(imc >=18.5 && imc < 25){
            return "Saldável";
        }else if(imc >=25 && imc < 30){
            return "Sobrepeso";
        }else if(imc >=30 && imc < 35){
            return "Obesidade grau I";
        }else if(imc >=35 && imc < 40){
            return "Obesidade grau II (severa)";
        }else if(imc > 40){
            return "Obesidade grau III (mórbida)";
        }else{
            return "inválido";
        }

    }


}
