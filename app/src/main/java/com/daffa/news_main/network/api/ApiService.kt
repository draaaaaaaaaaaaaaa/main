package com.daffa.news_main.network.api

import com.daffa.news_main.network.response.MainResponse
import com.daffa.news_main.network.response.MainResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/games")
    fun getMain() : Call<List<MainResponseItem>>
}