package com.example.imdmarket.model;

import java.util.ArrayList;
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


}
