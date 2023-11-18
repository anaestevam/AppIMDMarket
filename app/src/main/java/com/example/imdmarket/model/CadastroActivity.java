package com.example.imdmarket.model;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;

public class CadastroActivity extends AppCompatActivity {
    private EditText codigo, nome, descricao, estoque;
    private Button btnSalvar, btnLimpar;


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

        btnLimpar.setOnClickListener(v -> limparCampos());
        btnSalvar.setOnClickListener(v -> salvarProduto());
    }
    private void limparCampos() {
        nome.setText("");
        descricao.setText("");
        estoque.setText("");
        codigo.setText("");
    }

    private void salvarProduto() {
        if(nome.getText().toString().equals("") || codigo.getText().toString().equals("") || descricao.getText().toString().equals("") || estoque.getText().toString().equals("")){
            Toast.makeText(this, "Existem campos em branco!", Toast.LENGTH_SHORT).show();
        }else{
            //aqui vai codigo pra adicionar no vetor
            Produto p = new Produto();
            p.setCodigo_produto(codigo.getText().toString());
            p.setNome_produto(nome.getText().toString());
            p.setDescrição_produto(descricao.getText().toString());
            p.setEstoque(Integer.parseInt(estoque.getText().toString()));

            BancoDAO banco = null;
            banco.getInstance().salvarProduto(p);
            Toast.makeText(this, "tem "+banco.getInstance().getLista().toArray().length, Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        }


    }
}