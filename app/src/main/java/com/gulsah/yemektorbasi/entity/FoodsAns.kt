package com.gulsah.yemektorbasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FoodsAns(@SerializedName("kisiler")
               @Expose
               var foods: List<Foods>,
               @SerializedName("success")
               @Expose
               var success:Int) {
}