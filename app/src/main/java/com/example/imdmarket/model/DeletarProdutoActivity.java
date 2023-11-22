package com.example.imdmarket.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdmarket.database.BancoDAO;
import com.example.imdmarket.database.Produto;
import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;

public class DeletarProdutoActivity extends AppCompatActivity {

    private EditText codigo;
    private Button btnDeletarProduto, btnLimpar;
    private TextView imdmarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        codigo = findViewById(R.id.cod_prod);
        btnDeletarProduto = findViewById(R.id.btndeletarproduto);
        btnLimpar = findViewById(R.id.btnlimpar3);
        imdmarket = findViewById(R.id.imdmarket);

        btnLimpar.setOnClickListener(v -> limparCampo());
        btnDeletarProduto.setOnClickListener(v -> deletarProduto());
        imdmarket.setOnClickListener(v -> voltarMenu());
    }

    private void limparCampo() {
        codigo.setText("");
    }

    private void deletarProduto() {
        String codigoProduto = codigo.getText().toString();

        if (codigoProduto.isEmpty()) {
            Toast.makeText(this, "Informe um código válido para deletar o produto!", Toast.LENGTH_SHORT).show();
            return;
        }

        BancoDAO banco = new BancoDAO(this);

        try {
            Produto produtoExistente = banco.getProdutoByCodigo(codigoProduto);

            if (produtoExistente == null) {
                Toast.makeText(this, "Produto não encontrado com o código fornecido!", Toast.LENGTH_SHORT).show();
            } else {
                banco.deletarProduto(codigoProduto);
                Toast.makeText(this, "Produto deletado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
            }
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
