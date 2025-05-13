package com.example.deneme123.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

data class VoteRequest(val candidateId: Int)
data class VoteResponse(val success: Boolean)

interface VoteApi {
    @POST("vote")
    suspend fun vote(
        @Header("Authorization") bearer: String,
        @Body req: VoteRequest
    ): Response<VoteResponse>
}
