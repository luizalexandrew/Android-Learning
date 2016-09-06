package com.example.brain.calculadora;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.towel.math.Expression;


public class MainActivity extends AppCompatActivity {

    private View v;
    private String conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v){

        Button btn = (Button) v;
        String conteudoDigital = btn.getText().toString();
        adicionarValorExpressaoAtual(conteudoDigital);

    }

    public void adicionarValorExpressaoAtual(String conteudoDigitado){

        TextView consola = (TextView) findViewById(R.id.consola);
        String expresaoAtual = consola.getText().toString() + conteudoDigitado;
        consola.setText(expresaoAtual);

    }

    public void btnCalcular(View v) {
        TextView consola = (TextView) findViewById(R.id.consola);
        String expresaoMath = consola.getText().toString();
        calcularExpressao(expresaoMath);
    }

    protected void calcularExpressao(String expresaoMath) {
        Expression exp = new Expression(expresaoMath);
        double result = exp.resolve();
        TextView consola = (TextView) findViewById(R.id.consola);
        consola.setText(String.valueOf(result));
    }

    public void limparEntrada(View v){
        TextView consola = (TextView) findViewById(R.id.consola);
        consola.setText("");
    }

    public void removerUltimaEntrada(View v){
        TextView consola = (TextView) findViewById(R.id.consola);
        String expressaoMath = consola.getText().toString();

        if (expressaoMath.length() > 0){
            expressaoMath = expressaoMath.substring(0, expressaoMath.length()-1);
            consola.setText(expressaoMath);
        }

    }

}
