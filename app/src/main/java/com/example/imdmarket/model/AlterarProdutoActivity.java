package com.example.imdmarket.model;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;

public class AlterarProdutoActivity extends AppCompatActivity {
    private EditText codigo, nome, descricao, estoque;
    private Button btnSalvar, btnLimpar;
    private Produto produtoExistente;

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

        btnLimpar.setOnClickListener(v -> limparCampos());
        btnSalvar.setOnClickListener(v -> alterarProduto());

       /* if (!codigo.getText().toString().isEmpty()) {
            atualizarCamposAutomaticamente(codigo.getText().toString());
        }
        */
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

        BancoDAO banco = BancoDAO.getInstance();
        Produto produtoExistente = banco.getProdutoByCodigo(codigoProduto);

        if (produtoExistente == null) {
            Toast.makeText(this, "Produto não encontrado com o código fornecido!", Toast.LENGTH_SHORT).show();
            return;
        }

        produtoExistente.setNome_produto(nome.getText().toString());
        produtoExistente.setDescrição_produto(descricao.getText().toString());
        produtoExistente.setEstoque(Integer.parseInt(estoque.getText().toString()));

        Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

   /* private void atualizarCamposAutomaticamente(String codigoProduto) {
        BancoDAO banco = BancoDAO.getInstance();
        // Atualiza os campos automaticamente enquanto o usuário digita o código
        produtoExistente = banco.getProdutoByCodigo(codigoProduto);

        if (produtoExistente != null) {
            nome.setText(produtoExistente.getNome_produto());
            descricao.setText(produtoExistente.getDescrição_produto());
            estoque.setText(String.valueOf(produtoExistente.getEstoque()));
        }
    }*/
}
