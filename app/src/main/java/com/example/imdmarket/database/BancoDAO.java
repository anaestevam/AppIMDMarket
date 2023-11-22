package com.example.imdmarket.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoDAO extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "imd_market.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ProdutoTable.ProdutoEntry.TABLE_NAME + " (" +
                    ProdutoTable.ProdutoEntry._ID + " INTEGER PRIMARY KEY," +
                    ProdutoTable.ProdutoEntry.COLUMN_CODIGO + " TEXT," +
                    ProdutoTable.ProdutoEntry.COLUMN_NOME + " TEXT," +
                    ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO + " TEXT," +
                    ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ProdutoTable.ProdutoEntry.TABLE_NAME;

    public BancoDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void salvarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ProdutoTable.ProdutoEntry.COLUMN_CODIGO, produto.getCodigo_produto());
        values.put(ProdutoTable.ProdutoEntry.COLUMN_NOME, produto.getNome_produto());
        values.put(ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO, produto.getDescrição_produto());
        values.put(ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE, produto.getEstoque());

        db.insert(ProdutoTable.ProdutoEntry.TABLE_NAME, null, values);
        db.close();
    }

    public List<Produto> getLista() {
        List<Produto> listaProdutos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                ProdutoTable.ProdutoEntry._ID,
                ProdutoTable.ProdutoEntry.COLUMN_CODIGO,
                ProdutoTable.ProdutoEntry.COLUMN_NOME,
                ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO,
                ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE
        };

        Cursor cursor = db.query(
                ProdutoTable.ProdutoEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Produto produto = new Produto();
                produto.setCodigo_produto(cursor.getString(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_CODIGO)));
                produto.setNome_produto(cursor.getString(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_NOME)));
                produto.setDescrição_produto(cursor.getString(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO)));
                produto.setEstoque(cursor.getInt(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE)));
                listaProdutos.add(produto);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }

        db.close();
        return listaProdutos;
    }

    public void deletarProduto(String codigoProduto) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(
                ProdutoTable.ProdutoEntry.TABLE_NAME,
                ProdutoTable.ProdutoEntry.COLUMN_CODIGO + " = ?",
                new String[]{codigoProduto}
        );
        db.close();
    }

    public void atualizarProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ProdutoTable.ProdutoEntry.COLUMN_NOME, produto.getNome_produto());
        values.put(ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO, produto.getDescrição_produto());
        values.put(ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE, produto.getEstoque());

        String selection = ProdutoTable.ProdutoEntry.COLUMN_CODIGO + " = ?";
        String[] selectionArgs = {produto.getCodigo_produto()};

        db.update(
                ProdutoTable.ProdutoEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        db.close();
    }


    public Produto getProdutoByCodigo(String codigoProduto) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                ProdutoTable.ProdutoEntry._ID,
                ProdutoTable.ProdutoEntry.COLUMN_CODIGO,
                ProdutoTable.ProdutoEntry.COLUMN_NOME,
                ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO,
                ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE
        };

        String selection = ProdutoTable.ProdutoEntry.COLUMN_CODIGO + " = ?";
        String[] selectionArgs = {codigoProduto};

        Cursor cursor = db.query(
                ProdutoTable.ProdutoEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );


        Produto produto = null;

        if (cursor != null && cursor.moveToFirst()) {
            produto = new Produto();
            produto.setCodigo_produto(cursor.getString(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_CODIGO)));
            produto.setNome_produto(cursor.getString(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_NOME)));
            produto.setDescrição_produto(cursor.getString(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_DESCRICAO)));
            produto.setEstoque(cursor.getInt(cursor.getColumnIndexOrThrow(ProdutoTable.ProdutoEntry.COLUMN_ESTOQUE)));
        }

        if (cursor != null) {
            cursor.close();
        }

        db.close();
        return produto;
    }
}
