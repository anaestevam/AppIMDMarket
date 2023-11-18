package com.example.imdmarket.model;

public class Produto {
    private String codigo_produto;
    private String nome_produto;
    private String descrição_produto;
    private int estoque;

    public void setCodigo_produto(String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setDescrição_produto(String descrição_produto) {
        this.descrição_produto = descrição_produto;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public String getDescrição_produto() {
        return descrição_produto;
    }

    public int getEstoque() {
        return estoque;
    }
}
