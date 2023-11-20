package com.example.imdmarket.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.imdmarket.R;
import com.example.imdmarket.controller.MenuActivity;

public class ListaActivity extends AppCompatActivity {
    private ListView l1;

    private Button btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        l1 = (ListView) findViewById(R.id.listav);
        btnvoltar = findViewById(R.id.voltar_menu);

        btnvoltar.setOnClickListener(v -> voltarMenu());

        BancoDAO banco = null;

        String nomes[] = new String[banco.getInstance().getLista().toArray().length];

        for(int i=0; i < banco.getInstance().getLista().toArray().length; i++){
            Produto p = banco.getInstance().getLista().get(i);
            nomes[i] = p.getNome_produto();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nomes);
        l1.setAdapter(adapter);

    }

    private void voltarMenu(){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}