package com.necomplus.demo.Utils

import androidx.lifecycle.ViewModel
import com.necomplus.demo.retrofit.RetrofitApi
import com.necomplus.demo.retrofit.RetrofitConnection

open class CustomViewModel: ViewModel(){
    var api : RetrofitApi?=null
    var connection = RetrofitConnection()
    init {
        api = RetrofitConnection().api
    }
}