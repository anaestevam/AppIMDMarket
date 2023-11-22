package com.example.imdmarket.database;

import android.provider.BaseColumns;

public class ProdutoTable {
    private ProdutoTable() {}

    public static class ProdutoEntry implements BaseColumns {
        public static final String TABLE_NAME = "produtos";
        public static final String COLUMN_CODIGO = "codigo";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_DESCRICAO = "descricao";
        public static final String COLUMN_ESTOQUE = "estoque";
    }
}

