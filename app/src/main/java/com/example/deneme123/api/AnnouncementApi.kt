package com.example.deneme123.api

import com.example.deneme123.model.Announcement
import retrofit2.Response
import retrofit2.http.GET

interface AnnouncementApi {
    @GET("announcements")
    suspend fun getAll(): Response<List<Announcement>>
}
