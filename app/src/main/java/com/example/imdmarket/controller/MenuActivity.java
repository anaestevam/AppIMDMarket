package com.example.imdmarket.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imdmarket.R;
import com.example.imdmarket.model.*;


public class MenuActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnAlterar;
    private Button btnListar;
    private Button btnDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnAlterar = findViewById(R.id.btnAlterar);
        btnListar = findViewById(R.id.btnListar);
        btnDeletar = findViewById(R.id.btnDeletar);

        btnCadastrar.setOnClickListener(v -> abreCadastro());
        btnListar.setOnClickListener(v -> abreLista());
        btnAlterar.setOnClickListener(v -> alterarProduto());
        btnDeletar.setOnClickListener(v -> deletarProduto());
    }
    private void abreCadastro() {

        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }

    private void abreLista() {

        Intent i = new Intent(this, ListaActivity.class);
        startActivity(i);
    }

    private void alterarProduto(){
        Intent i = new Intent(this, AlterarProdutoActivity.class);
        startActivity(i);
    }

    private void deletarProduto(){
        Intent i = new Intent(this, DeletarProdutoActivity.class);
        startActivity(i);
    }
}
