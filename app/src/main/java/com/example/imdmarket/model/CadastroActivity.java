package com.example.imdmarket.model;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdmarket.database.BancoDAO;
import com.example.imdmarket.database.Produto;
import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;

public class CadastroActivity extends AppCompatActivity {
    private EditText codigo, nome, descricao, estoque;
    private Button btnSalvar, btnLimpar;
    private TextView imdmarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        codigo = findViewById(R.id.codigo);
        nome = findViewById(R.id.nome);
        descricao = findViewById(R.id.descricao);
        estoque = findViewById(R.id.estoque);
        btnSalvar = findViewById(R.id.btnsalvar);
        btnLimpar = findViewById(R.id.btnlimpar);
        imdmarket = findViewById(R.id.imdmarket);

        btnLimpar.setOnClickListener(v -> limparCampos());
        btnSalvar.setOnClickListener(v -> salvarProduto());
        imdmarket.setOnClickListener(v -> voltarMenu());
    }
    private void limparCampos() {
        nome.setText("");
        descricao.setText("");
        estoque.setText("");
        codigo.setText("");
    }

    private void salvarProduto() {
        String nomeProduto = nome.getText().toString();
        String codigoProduto = codigo.getText().toString();
        String descricaoProduto = descricao.getText().toString();
        String estoqueProduto = estoque.getText().toString();

        if (nomeProduto.equals("") || codigoProduto.equals("") || descricaoProduto.equals("") || estoqueProduto.equals("")) {
            Toast.makeText(this, "Existem campos em branco!", Toast.LENGTH_SHORT).show();
            return;
        }

        BancoDAO banco = new BancoDAO(this);

        try {
            Produto produto = new Produto();
            produto.setCodigo_produto(codigoProduto);
            produto.setNome_produto(nomeProduto);
            produto.setDescrição_produto(descricaoProduto);
            produto.setEstoque(Integer.parseInt(estoqueProduto));

            banco.salvarProduto(produto);
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        } finally {
            banco.close();
        }
    }
    private void voltarMenu() {
        finish();
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

}