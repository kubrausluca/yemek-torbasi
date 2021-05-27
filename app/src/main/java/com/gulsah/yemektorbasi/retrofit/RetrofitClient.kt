package com.gulsah.yemektorbasi.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    // static veri oluşturma işlemine companion object denir kotlinde ve bu şekilde tanımlanır, javada static
    companion object{
        fun getClient(baseUrl: String):Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}