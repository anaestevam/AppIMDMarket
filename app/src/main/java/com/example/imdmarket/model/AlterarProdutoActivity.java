package com.example.imdmarket.model;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;
import com.example.imdmarket.database.BancoDAO;
import com.example.imdmarket.database.Produto;

public class AlterarProdutoActivity extends AppCompatActivity {
    private EditText codigo, nome, descricao, estoque;
    private Button btnSalvar, btnLimpar;
    private Produto produtoExistente;
    private TextView imdmarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = findViewById(R.id.codigo);
        nome = findViewById(R.id.nome);
        descricao = findViewById(R.id.descricao);
        estoque = findViewById(R.id.estoque);
        btnSalvar = findViewById(R.id.btnsalvar);
        btnLimpar = findViewById(R.id.btnlimpar);
        imdmarket = findViewById(R.id.imdmarket);

        btnLimpar.setOnClickListener(v -> limparCampos());
        btnSalvar.setOnClickListener(v -> alterarProduto());
        imdmarket.setOnClickListener(v -> voltarMenu());
    }

    private void limparCampos() {
        nome.setText("");
        descricao.setText("");
        estoque.setText("");
        codigo.setText("");
        produtoExistente = null;
    }

    private void alterarProduto() {
        String codigoProduto = codigo.getText().toString();

        if (codigoProduto.equals("")) {
            Toast.makeText(this, "Informe o código do produto a ser alterado!", Toast.LENGTH_SHORT).show();
            return;
        }

        BancoDAO banco = new BancoDAO(this); // 'this' é uma referência a atividade
        produtoExistente = banco.getProdutoByCodigo(codigoProduto);

        if (produtoExistente == null) {
            Toast.makeText(this, "Produto não encontrado com o código fornecido!", Toast.LENGTH_SHORT).show();
            limparCampos();  // Limpa os campos caso o produto não seja encontrado
            banco.close(); // Fecha o banco de dados
            return;
        }else{

            if (nome.getText().toString().isEmpty() || descricao.getText().toString().isEmpty() || estoque.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }
            produtoExistente.setNome_produto(nome.getText().toString());
            produtoExistente.setDescrição_produto(descricao.getText().toString());
            produtoExistente.setEstoque(Integer.parseInt(estoque.getText().toString()));

            banco.atualizarProduto(produtoExistente);
            Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT).show();

            banco.close();

            finish();
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        }


    }
    private void voltarMenu() {
        finish();
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

}
