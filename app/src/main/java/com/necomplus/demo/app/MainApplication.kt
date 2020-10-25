package com.necomplus.demo.app

import android.app.Application
import com.necomplus.demo.main.modules.mainModule
import com.necomplus.demo.main.modules.tracksModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(getModules())
        }
    }

    private fun getModules() = arrayListOf(
        mainModule,
        tracksModule
    )
}