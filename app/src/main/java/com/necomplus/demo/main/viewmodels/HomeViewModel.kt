package com.necomplus.demo.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.necomplus.demo.Utils.CustomViewModel
import com.necomplus.demo.models.Artist
import com.necomplus.demo.retrofit.RetrofitApi
import com.necomplus.demo.retrofit.RetrofitConnection

class HomeViewModel : CustomViewModel() {

    var isLoading = MutableLiveData<Boolean>()

    var error = MutableLiveData<String>()
    var artistList = MutableLiveData<ArrayList<Artist>>()
    fun getTop10Artist(){
        isLoading.value = true
        connection.connection(api!!.getTop10Artist()){ response, error ->
            if (error != null){
                this.error.postValue(error)
                isLoading.value = false
                return@connection
            }
            this.artistList.postValue(response!!.topArtists.artist)
            isLoading.value = false
        }
    }

}