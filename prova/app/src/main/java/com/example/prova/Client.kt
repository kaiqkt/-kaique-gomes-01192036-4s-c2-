package com.example.prova

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    fun criar() : GetCachorros{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(GetCachorros::class.java)

        return api
    }
}