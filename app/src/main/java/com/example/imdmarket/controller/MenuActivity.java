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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.d("MenuActivity", "onCreate");

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        Button btnListar = findViewById(R.id.btnListar);
        Button btnDeletar = findViewById(R.id.btnDeletar);
        Button btnAlterar = findViewById(R.id.btnAlterar);

        btnCadastrar.setOnClickListener(v -> abreCadastro());
        btnListar.setOnClickListener(v -> abreLista());
       /* btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de cadastro ao clicar em "Cadastrar produto"
                Intent intent = new Intent(MenuActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de listagem ao clicar em "Listar Produtos"
                Intent intent = new Intent(MenuActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de exclusão ao clicar em "Deletar Produtos"
                Intent intent = new Intent(MenuActivity.this, DeletarProdutoActivity.class);
                startActivity(intent);
            }
        });

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegue para a tela de alteração ao clicar em "Alterar Produto"
                Intent intent = new Intent(MenuActivity.this, AlterarProdutoActivity.class);
                startActivity(intent);
            }
        });*/
    }

    private void abreCadastro() {

        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }
    private void abreLista() {
        Intent i = new Intent(this, ListaActivity.class);
        startActivity(i);
    }
}
