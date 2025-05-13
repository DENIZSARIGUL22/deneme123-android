package com.example.deneme123.api

import com.example.deneme123.model.LoginRequest
import com.example.deneme123.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    suspend fun login(@Body req: LoginRequest): Response<LoginResponse>
}
