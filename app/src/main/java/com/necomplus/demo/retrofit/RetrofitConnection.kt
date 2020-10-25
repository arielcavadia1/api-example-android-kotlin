package com.necomplus.demo.retrofit

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.Console

class RetrofitConnection {
    private lateinit var disposable : Disposable
    var api : RetrofitApi = RetrofitClient().getInstance().create(RetrofitApi::class.java)

    fun<T> connection(method: Observable<T>,callback: (response:T?, error : String?) -> Unit){
        disposable =  method.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("retrofitConnection","reponse $it")
                callback.invoke(it,null)
            },{
                Log.d("retrofitConnection","error $it")
                callback.invoke(null,"error al obtener los datos")
            })
    }

}