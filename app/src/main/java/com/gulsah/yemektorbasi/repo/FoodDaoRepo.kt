package com.gulsah.yemektorbasi.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gulsah.yemektorbasi.entity.Foods
import com.gulsah.yemektorbasi.entity.FoodsAns
import com.gulsah.yemektorbasi.retrofit.ApiUtils
import com.gulsah.yemektorbasi.retrofit.FoodsDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDaoRepo {
    private val foodlist : MutableLiveData<List<Foods>>
    private val fdaoi : FoodsDao
    init {
        fdaoi = ApiUtils.getFoodDao()
        foodlist = MutableLiveData()
    }
    fun foodGet():MutableLiveData<List<Foods>>{
        return foodlist
    }
    fun foodShow() {
        fdaoi.AllFoods().enqueue(object : Callback<FoodsAns> {
            override fun onResponse(call: Call<FoodsAns>, response: Response<FoodsAns>) {
                val list = response.body()!!.foods
                foodlist.value = list
            }

            override fun onFailure(call: Call<FoodsAns>, t: Throwable) {

            }

        })
    }

}