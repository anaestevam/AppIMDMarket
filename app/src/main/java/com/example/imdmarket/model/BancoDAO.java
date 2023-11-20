package com.example.imdmarket.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDAO {
    List<Produto> listaProdutos = new ArrayList<>();
    private static BancoDAO instance;
    public static BancoDAO getInstance(){
        if(instance == null){
            instance = new BancoDAO();
        }return instance;
    }
    private BancoDAO(){
        listaProdutos = new ArrayList<>();
    }

    public void salvarProduto(Produto produto){
        listaProdutos.add(produto);
    }

    public List<Produto> getLista(){
        return listaProdutos;
    }

    public void deletarProduto(String codigoProduto) {
        Iterator<Produto> iterator = listaProdutos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getCodigo_produto().equals(codigoProduto)) {
                iterator.remove();
                break;
            }
        }
    }

    public Produto getProdutoByCodigo(String codigoProduto) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo_produto().equals(codigoProduto)) {
                return produto;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }
}
