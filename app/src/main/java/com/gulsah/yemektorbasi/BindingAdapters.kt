package com.gulsah.yemektorbasi

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:setPrice")
fun setPrice (textview : TextView, price : Double){
    textview.text = "$price \u20BA"
}
