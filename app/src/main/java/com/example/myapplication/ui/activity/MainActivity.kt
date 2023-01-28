package com.example.myapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dao.ProdutoDao
import com.example.myapplication.model.Produtos
import com.example.myapplication.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal
import android.app.ActivityManager as ActivityManager1

class MainActivity:AppCompatActivity(R.layout.activity_main) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val produtoDao = ProdutoDao()

        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = produtoDao.buscarProduto() )
        
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val produtoDao = ProdutoDao()

        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = produtoDao.buscarProduto() )

        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }
}