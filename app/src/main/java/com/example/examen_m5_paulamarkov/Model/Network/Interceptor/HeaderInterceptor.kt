package com.example.examen_m5_paulamarkov.Model.Network.Interceptor

import com.example.examen_m5_paulamarkov.Model.Token.objKen
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "Accept:", "application/json"
            )
            .addHeader("Authorization", "Bearer $objKen")
            .build()

        return chain.proceed(request)
    }


}