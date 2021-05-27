package com.gulsah.yemektorbasi.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getFoodDao():FoodsDao {
            return RetrofitClient.getClient(BASE_URL).create(FoodsDao::class.java)
        }
    }
}