package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R
import com.example.myapplication.dao.ProdutoDao
import com.example.myapplication.model.Produtos
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener() {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoValor = findViewById<EditText>(R.id.valor)
            val valorTexto = campoValor.text.toString()

            val valor = if (valorTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorTexto)
            }

            val produtoNovo = Produtos(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            //Log.i("FormularioProdutoActivity", "onCreate: $produtoNovo")
            val produtoDao = ProdutoDao()
                produtoDao.adicionarProduto(produtoNovo)
            Log.i("FormularioProdutoActivity", "onCreate: ${produtoDao.buscarProduto()}")
            finish()

        }


    }
}