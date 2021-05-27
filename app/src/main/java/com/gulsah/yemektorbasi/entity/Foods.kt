package com.gulsah.yemektorbasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Foods(
    @SerializedName("yemek_id")
    @Expose
    var id: Int,
    @SerializedName("yemek_resim_adi")
    @Expose
    var pic_name: String,
    @SerializedName("yemek_adi")
    @Expose
    var name: String,
    @SerializedName("yemek_fiyat")
    @Expose
    var price: Int,
) {
}