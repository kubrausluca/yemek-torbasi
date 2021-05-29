package com.gulsah.yemektorbasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulsah.yemektorbasi.FoodAdapter
import com.gulsah.yemektorbasi.Foods
import com.gulsah.yemektorbasi.R
import com.gulsah.yemektorbasi.databinding.FragmentHomePageBinding
import com.gulsah.yemektorbasi.entity.FoodsAns
import com.gulsah.yemektorbasi.retrofit.ApiUtils
import com.gulsah.yemektorbasi.retrofit.FoodsDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageFragment : Fragment() {

    private lateinit var layout: FragmentHomePageBinding
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: ArrayList<Foods>
    private lateinit var fdaoi: FoodsDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        fdaoi = ApiUtils.getFoodDao()

        layout.rv.layoutManager = LinearLayoutManager(requireContext())

        foodShow()

        return layout.root
    }

    fun foodShow() {
        fdaoi.AllFoods().enqueue(object : Callback<FoodsAns> {
            override fun onResponse(call: Call<FoodsAns>, response: Response<FoodsAns>) {
                val foodList = response.body()!!.foods

                for (f in foodList) {
                    Log.e("***************", "*************")
                    Log.e("yemek adi", f.yemek_adi.toString())
                }
            }

            override fun onFailure(call: Call<FoodsAns>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}



