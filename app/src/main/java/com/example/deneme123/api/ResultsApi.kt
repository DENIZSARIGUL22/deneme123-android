package com.example.deneme123.api

import retrofit2.Response
import retrofit2.http.GET

data class ResultsResponse(
    val id: Int,
    val name: String,
    val votes: Int
)

interface ResultsApi {
    @GET("results")
    suspend fun getResults(): Response<List<ResultsResponse>>
}
