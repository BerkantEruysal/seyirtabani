package com.merberk.seyirtabani.service

import com.merberk.seyirtabani.model.APIResponse
import com.merberk.seyirtabani.model.Show
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ShowAPI {


    @GET("trending/all/week?language=en-US")
    fun getCountries(@Header("Authorization") token : String): Call<APIResponse>

}