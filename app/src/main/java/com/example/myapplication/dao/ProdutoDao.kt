package com.example.myapplication.dao

import com.example.myapplication.model.Produtos

class ProdutoDao {

    fun adicionarProduto(produto: Produtos){
        produtos.add(produto)
    }

    fun buscarProduto(): List<Produtos>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>()
    }

}