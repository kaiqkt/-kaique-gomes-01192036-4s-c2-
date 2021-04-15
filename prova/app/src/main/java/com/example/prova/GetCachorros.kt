package com.example.prova

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCachorros {
    @GET("cachorros/{id}")
    fun get(@Path("id") id: Int): Call<Cachorros>
}