package com.example.hogwarts.network.api

import com.example.hogwarts.network.dto.SpellDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSpell {

    @GET("v1/spells")
    suspend fun getAllSpells(
        @Query("key") key: String
    ): Response<ArrayList<SpellDTO>>
}
