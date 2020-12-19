package com.odinwar.mvvmdemoapp.data.source.remote.getapi

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Call
import okhttp3.EventListener
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GetDataFromApi {
    private const val OKHTTP3 = "OKHTTP3"
    private const val START = "START"
    private const val END = "END"
    private const val TIME_OUT = 5L
    private const val INTERVAL = 1L
    private val builder = Retrofit.Builder()
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        .client(getHttpClient().build())

    private fun getHttpClient() = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        connectTimeout(TIME_OUT, TimeUnit.SECONDS).pingInterval(INTERVAL, TimeUnit.SECONDS)
            .eventListener(object : EventListener() {
                override fun callStart(call: Call) {
                    super.callStart(call)
                    Log.e(OKHTTP3, START)
                }

                override fun callEnd(call: Call) {
                    super.callEnd(call)
                    Log.e(OKHTTP3, END)
                }
            })
    }

    fun <S> loadDataFromApi(path: String, classService: Class<S>): S =
        builder.baseUrl(path).build().create(classService)
}
