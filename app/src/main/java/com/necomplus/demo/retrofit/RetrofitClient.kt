package com.necomplus.demo.retrofit

import com.google.gson.GsonBuilder
import com.necomplus.demo.Utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class RetrofitClient {
    private var newInstance : Retrofit? = null

    fun getInstance() : Retrofit {
        if (newInstance == null) {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            newInstance = Retrofit.Builder()
                .baseUrl(Constants().urlBase)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getUnsafeOkHttpClient().build())
                .build()
        }
        return newInstance!!
    }

     fun createService(serviceClass: Class<RetrofitApi>): RetrofitApi {
        return RetrofitClient().getInstance().create(serviceClass)
    }




    fun getUnsafeOkHttpClient(): OkHttpClient.Builder {

        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {

                }

                override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {

                }

                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }

            })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname, session -> true }
            return builder
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }


}