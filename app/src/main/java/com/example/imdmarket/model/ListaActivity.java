package com.example.imdmarket.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.imdmarket.R;
public class ListaActivity extends AppCompatActivity {
    private ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        l1 = (ListView) findViewById(R.id.listav);

        BancoDAO banco = null;

        String nomes[] = new String[banco.getInstance().getLista().toArray().length];

        for(int i=0; i < banco.getInstance().getLista().toArray().length; i++){
            Produto p = banco.getInstance().getLista().get(i);
            nomes[i] = p.getNome_produto();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nomes);
        l1.setAdapter(adapter);

    }
}