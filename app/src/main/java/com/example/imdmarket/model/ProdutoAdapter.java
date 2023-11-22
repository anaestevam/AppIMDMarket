package com.example.imdmarket.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.imdmarket.R;
import com.example.imdmarket.database.Produto;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    public ProdutoAdapter(Context context, List<Produto> produtos) {
        super(context, 0, produtos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false);
        }

        TextView title = convertView.findViewById(R.id.title);
        TextView subtitle = convertView.findViewById(R.id.subtitle);

        title.setText(produto.getNome_produto());
        subtitle.setText(produto.getDescrição_produto());

        return convertView;
    }
}

