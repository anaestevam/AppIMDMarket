package com.example.imdmarket.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.imdmarket.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cria um Intent para a LoginActivity
        Intent intent = new Intent(this, LoginActivity.class);

        // Inicia o LoginActivity
        startActivity(intent);

        // Finaliza a MainActivity para que ela não fique na pilha de atividades
        finish();
    }
}
