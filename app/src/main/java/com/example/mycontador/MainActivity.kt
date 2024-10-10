package com.example.mycontador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textContador = findViewById<TextView>(R.id.textView)
        val btn_aumentar = findViewById<Button>(R.id.activity_main_btn_aumentar)
        val btn_diminuir = findViewById<Button>(R.id.activity_main_btn_diminuir)

        // Atualiza o valor do contador e desabilita o botão diminuir se contador == 0
        fun updateCounter() {
            textContador.text = "$contador"
            btn_diminuir.isEnabled = contador > 0
        }

        btn_aumentar.setOnClickListener {
            contador++
            updateCounter()
        }

        btn_diminuir.setOnClickListener {
            if (contador > 0) {
                contador--
                updateCounter()
            }
        }

        // Inicializa o estado do botão "diminuir"
        updateCounter()
    }
}
