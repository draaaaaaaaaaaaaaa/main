package com.daffa.news_main.componen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.news_main.network.api.ApiConfig
import com.daffa.news_main.network.response.MainResponse
import com.daffa.news_main.network.response.MainResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel :ViewModel() {

    private val listMain = MutableLiveData<List<MainResponseItem>>()

    fun getMainModel(){
        ApiConfig().getApiService().getMain().enqueue(object : Callback<List<MainResponseItem>> {
            override fun onResponse(
                call: Call<List<MainResponseItem>>,
                response: Response<List<MainResponseItem>>
            ) {
                listMain.value = response.body()
            }

            override fun onFailure(call: Call<List<MainResponseItem>>, t: Throwable) {

            }
        })
    }

    fun getListMain(): LiveData<List<MainResponseItem>> = listMain
}