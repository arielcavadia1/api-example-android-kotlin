package com.necomplus.demo.Utils

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.necomplus.demo.R
import kotlinx.android.synthetic.main.custom_progress.view.*

class CustomProgress(activity: Activity){
    private var viewGroup : ViewGroup?=null
    private var view : View?=null
    private var count = 0
    init {
        view = activity.layoutInflater.inflate(R.layout.custom_progress, null)
        viewGroup = activity.window.decorView.findViewById(android.R.id.content)
    }


    fun showProgress(){
        hideProgress()
        viewGroup?.addView(view)


    }


    fun hideProgress() {
        if(viewGroup != null && view != null) {
            viewGroup?.removeView(view)
        }
    }



}