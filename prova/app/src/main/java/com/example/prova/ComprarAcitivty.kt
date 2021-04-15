package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ComprarAcitivty : AppCompatActivity() {

    private var firstBundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar_acitivty)

        firstBundle = intent.extras

        val id1 = firstBundle?.get("r1")
        val id2 = firstBundle?.get("r2")
        val total = firstBundle?.get("total")

        val msg1 = getString(R.string.cachorro1, id1)
        val msg2 = getString(R.string.cachorro2, id2)
        val msg3 = getString(R.string.total, total)

        findViewById<TextView>(R.id.comprar1).text = msg1
        findViewById<TextView>(R.id.comprar2).text = msg2
        findViewById<TextView>(R.id.comprar3).text = msg3
    }
}