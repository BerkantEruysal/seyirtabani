package com.merberk.seyirtabani.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.merberk.seyirtabani.database.ShowDao
import com.merberk.seyirtabani.database.ShowDatabase
import com.merberk.seyirtabani.model.APIResponse
import com.merberk.seyirtabani.model.Show
import com.merberk.seyirtabani.service.ShowAPIService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val showAPI = ShowAPIService()

    val showData = MutableLiveData<List<Show>>()
    val showLoad = MutableLiveData<Boolean>()
    val showError = MutableLiveData<Boolean>()

    private var showDatabase: ShowDatabase? = null
    private var showDao: ShowDao? = null
    val show = MutableLiveData<Show>()
    init {
        showDatabase = ShowDatabase.getInstance(application)
        showDao = showDatabase?.showDao()
    }

    fun getDataFromAPI(){
        showLoad.value = true

        showAPI.getData().enqueue(object: Callback<APIResponse>{
            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                showData.value = response.body()?.results
                showLoad.value = false
                showError.value = false
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                showLoad.value = false
                showError.value = true
                Log.e("RetrofitError",t.message.toString())
            }
        })

    }

    fun insertAll(list: List<Show>) = viewModelScope.launch {
        showDao?.insertAll(list)
    }

    fun findByName (name:String) = viewModelScope.launch {
        show.value = showDao?.findByName(name)
    }
}