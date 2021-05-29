package com.gulsah.yemektorbasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Foods(
    @SerializedName("yemek_id")
    @Expose
    var id: Int,
    @SerializedName("yemek_resim_adi")
    @Expose
    var yemek_resim_adi: String,
    @SerializedName("yemek_adi")
    @Expose
    var yemek_adi: String,
    @SerializedName("yemek_fiyat")
    @Expose
    var yemek_fiyat: Int,
) {
}