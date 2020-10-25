package com.necomplus.demo.main.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.necomplus.demo.Utils.CustomViewModel
import com.necomplus.demo.models.Track

class TracksViewModel : CustomViewModel(){

    var isLoading = MutableLiveData<Boolean>()
    var trackList = MutableLiveData<ArrayList<Track>>()
    var error = MutableLiveData<String>()

    fun getTracksFromArtist(artistMbid : String){
        isLoading.value = true
        connection.connection(api!!.getTop5TracktByArtist(artistMbid)){ response, error ->
            Log.d("getTracks", "$response")
            Log.d("getTracks","$error")
            if (error != null){
                this.error.postValue(error)
                isLoading.value = false
                return@connection
            }
            this.trackList.postValue(response!!.topTracks.track)
            isLoading.value = false
        }

    }


}