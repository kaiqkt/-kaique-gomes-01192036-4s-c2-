package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FailedActivity : AppCompatActivity() {

    private var firstBundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failed)

        firstBundle = intent.extras

        val id1 = firstBundle?.get("c1")
        val id2 = firstBundle?.get("c2")
        val mensagem = getString(R.string.not, id1, id2)
        findViewById<TextView>(R.id.result).text = mensagem
    }
}