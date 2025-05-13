package com.example.deneme123.model

data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val message: String?
)
