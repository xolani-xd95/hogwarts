package com.example.hogwarts.network.api


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiStudent {
    @GET("v1/characters")
    suspend fun getCharacters(): Response<String>

    @GET("v1/characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: String): Response<String>
}