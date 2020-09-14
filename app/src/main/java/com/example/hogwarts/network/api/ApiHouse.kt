package com.example.hogwarts.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiHouse {
    @GET("v1/house")
    suspend fun getHouses(): Response<String>

    @GET("v1/house/{houseId}")
    suspend fun getHouseById(@Path("houseId") houseId: String): Response<String>
}