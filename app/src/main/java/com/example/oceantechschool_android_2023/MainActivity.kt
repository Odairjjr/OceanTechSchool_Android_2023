package com.example.oceantechschool_android_2023

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.http.GET

data class ListPokemonResult(
    val name: String,
    val url: String
)

data class ListPokemonApiResult(
    val count: Int,
    val next: String,
    val previous: String,
    val results: Array<ListPokemonResult>
)

    interface PokeApiService{

        //https://pokeapi.co/api/v2/pokemon/?limit=20&offset=0
        //Base: https://pokeapi.co/api/v2/
        //Endpoint (rota): pokemon/?limit=20&offset=0
        @GET("pokemon/?limit=20&offset=0")
        fun listPokemon(): Call<ListPokemonApiResult> //colocar: Call retrofit2
    }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()

        val service = retrofit.crate(PokeApiService::class.java)
    }
}