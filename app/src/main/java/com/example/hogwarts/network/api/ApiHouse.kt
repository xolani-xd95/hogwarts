package com.example.hogwarts.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiHouse {
    @GET("v1/houses")
    suspend fun getHouses(@Query("key") key: String): Response<ArrayList<String>>

    @GET("v1/houses/{houseId}")
    suspend fun getHouseById(
        @Path("houseId") houseId: String,
        @Query("key") key: String
    ): Response<String>
}