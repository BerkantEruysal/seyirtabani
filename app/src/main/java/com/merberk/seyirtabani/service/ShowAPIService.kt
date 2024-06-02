package com.merberk.seyirtabani.service

import com.merberk.seyirtabani.model.APIResponse
import com.merberk.seyirtabani.model.Show
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShowAPIService {
    

    private val BASE_URL = "https://api.themoviedb.org/3/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ShowAPI::class.java)

    fun getData(): Call<APIResponse>{
        return api.getCountries("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMDA0ZDcwNDkxZmJkYjhkYWZhYTZjZDFkNmI4Yjg2NyIsInN1YiI6IjY2NGUyN2ZmZjU3YzIzYTM2MTA2MTg1NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Aa0OMqS-cOZeosm75h-TkPTXgH1Ru1lTc08PYm2zYes")
    }

}