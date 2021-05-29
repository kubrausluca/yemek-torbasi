package com.gulsah.yemektorbasi.retrofit

import com.gulsah.yemektorbasi.entity.Foods
import com.gulsah.yemektorbasi.entity.FoodsAns
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    @GET("yemekler/tum_yemekler.php")
    fun AllFoods(): retrofit2.Call<FoodsAns>

    @POST("yemekler/tum_yemekler_arama.php")
    @FormUrlEncoded
    fun foodSearch(@Field("yemek_adi") yemek_adi: String): retrofit2.Call<FoodsAns>

}