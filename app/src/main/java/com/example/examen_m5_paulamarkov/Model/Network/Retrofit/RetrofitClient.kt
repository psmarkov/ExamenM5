package com.example.examen_m5_paulamarkov.Model.Network.Retrofit

import com.example.examen_m5_paulamarkov.Model.Network.Api.WalletApi
import com.example.examen_m5_paulamarkov.Model.Network.Interceptor.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    private const val BASE_URL = "http://wallet-main.eba-ccwdurgr.us-east-1.elasticbeanstalk.com/"

    // Variable para test
    lateinit var  retrofitInstance : Retrofit

    // Conexion a la Api sin token
    fun getRetrofit() : WalletApi {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(getClient())
            .build()

        return retrofit.create(WalletApi::class.java)
    }

    // Conexion a la Api con Token
    fun getRetrofit2() : WalletApi {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()

        return retrofit.create(WalletApi::class.java)
    }


    private fun getClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()



}