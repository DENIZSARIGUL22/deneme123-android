package com.example.deneme123.api

import com.example.deneme123.model.Candidate
import retrofit2.Response
import retrofit2.http.GET

interface CandidateApi {
    @GET("candidates")
    suspend fun getAll(): Response<List<Candidate>>
}
