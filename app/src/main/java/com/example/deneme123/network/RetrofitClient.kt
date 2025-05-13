package com.example.deneme123.network

import com.example.deneme123.api.AnnouncementApi
import com.example.deneme123.api.AuthApi
import com.example.deneme123.api.CandidateApi
import com.example.deneme123.api.ResultsApi
import com.example.deneme123.api.VoteApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // 1) Emülatörde localhost’a erişim
    private const val BASE_URL = "http://10.0.2.2:5000/"

    // 2) Gerçek cihaz için (aynı ağdaki PC’nizin IP’si)
    // private const val BASE_URL = "http://192.168.1.102:5000/"

    // Ortak OkHttpClient — tüm istekleri log’lar
    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    // Ortak Retrofit örneği
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // API servislerinin hepsi bu retrofit örneğinden üretiliyor
    val authApi: AuthApi by lazy {
        retrofit.create(AuthApi::class.java)
    }
    val candidateApi: CandidateApi by lazy {
        retrofit.create(CandidateApi::class.java)
    }
    val voteApi: VoteApi by lazy {
        retrofit.create(VoteApi::class.java)
    }
    val resultsApi: ResultsApi by lazy {
        retrofit.create(ResultsApi::class.java)
    }
    val announcementApi: AnnouncementApi by lazy {
        retrofit.create(AnnouncementApi::class.java)
    }


}
