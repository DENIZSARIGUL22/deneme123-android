// model/Candidate.kt
package com.example.deneme123.model

import java.io.Serializable

data class Candidate(
    val id: Int,
    val name: String,
    val department: String,
    val bio: String,
    val photoUrl: String? = null
) : Serializable
