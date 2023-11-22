package com.example.imdmarket.model;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.imdmarket.database.BancoDAO;
import com.example.imdmarket.database.Produto;
import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;

public class ListaActivity extends AppCompatActivity {
    private ListView l1;
    private Button btnvoltar;
    private TextView imdmarket;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        l1 = findViewById(R.id.listav);
        btnvoltar = findViewById(R.id.voltar_menu);
        imdmarket = findViewById(R.id.imdmarket);

        btnvoltar.setOnClickListener(v -> voltarMenu());

        imdmarket.setOnClickListener(v -> voltarMenu());

        BancoDAO banco = new BancoDAO(this);
        List<Produto> listaProdutos = banco.getLista();

        Collections.sort(listaProdutos, new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return p1.getNome_produto().compareTo(p2.getNome_produto());
            }
        });

        ProdutoAdapter adapter = new ProdutoAdapter(this, listaProdutos);
        l1.setAdapter(adapter);

        l1.setOnItemClickListener((parent, view, position, id) -> {
            // O produto selecionado
            Produto produtoSelecionado = listaProdutos.get(position);

            // Exibe os detalhes em um Alert
            exibirDetalhes(produtoSelecionado);
        });

        banco.close();
    }

    private void exibirDetalhes(Produto produto) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Detalhes do Produto");
        builder.setMessage("\nCódigo: " + produto.getCodigo_produto() + "\n\nNome: " + produto.getNome_produto() + "\n\nDescrição: " + produto.getDescrição_produto() + "\n\nEstoque: " + produto.getEstoque());
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void voltarMenu() {
        finish();
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

}