package com.example.brain.myapplicationhello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","Aplicação no onCreate!");

        Button b = (Button) findViewById(R.id.vamopohaa);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Segunda);
                startActivity(it);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","Aplicação no onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","Aplicação no onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "Aplicação no onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","Aplicação no onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","Aplicação no onDestroy");
    }
}