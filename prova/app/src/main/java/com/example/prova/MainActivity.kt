package com.example.prova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val client = Client.criar()

    fun comprar(view: View) {
        val intentFailed = Intent(this, FailedActivity::class.java)
        val intentSuccess = Intent(this, ComprarAcitivty::class.java)

        val infoS = Bundle()
        val infoF = Bundle()

        var cachorro1: Cachorros? = null
        var cachorro2: Cachorros? = null

        val id1: EditText = findViewById(R.id.id_cachorro1)
        val id2: EditText = findViewById(R.id.id_cachorro2)

        client.get(id1.text.toString().toInt()).enqueue(object : Callback<Cachorros> {
            override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                cachorro1 = response.body()

                client.get(id2.text.toString().toInt()).enqueue(object : Callback<Cachorros> {
                    override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                        cachorro2 = response.body()

                        if (cachorro1 == null && cachorro2 == null) {
                            infoF.putString("c1", id1.text.toString())
                            infoF.putString("c2", id2.text.toString())
                            intentFailed.putExtras(infoF)

                            startActivity(intentFailed)
                        }

                        val r1 = if (cachorro1?.raca != null) cachorro1?.raca.toString() else "(não encontrado)"
                        val r2 = if (cachorro2?.raca != null) cachorro2?.raca.toString() else "(não encontrado)"
                        var preco1 = 0
                        var preco2 = 0

                        cachorro1?.precoMedio?.let {
                            preco1 = it
                        }

                        cachorro2?.precoMedio?.let {
                            preco2 = it
                        }

                        val total = preco1.plus(preco2)

                        infoS.putString("r1", r1)
                        infoS.putString("r2", r2)
                        infoS.putString("total", total.toString())

                        intentSuccess.putExtras(infoS)

                        startActivity(intentSuccess)
                    }

                    override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })

            }

            override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


}