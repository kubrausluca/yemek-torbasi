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
    private lateinit var foodList : ArrayList<Foods>
    private lateinit var fdaoi : FoodsDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        fdaoi = ApiUtils.getFoodDao()

        layout.rv.layoutManager = LinearLayoutManager(requireContext())
        foodList = ArrayList()
        val f1 = Foods(1,"resim adi","yemek adi",50)
        val f2 = Foods(1,"resim adi","yemek adi",50)
        val f3 = Foods(1,"resim adi","yemek adi",5065)
        foodList.add(f1)
        foodList.add(f2)
        foodList.add(f3)
        foodShow()

        adapter = FoodAdapter(requireContext(), foodList)
        layout.rv.adapter = adapter
        return layout.root
    }
    fun foodShow(){
        fdaoi.AllFoods().enqueue(object : Callback<FoodsAns> {
            override fun onResponse(call: Call<FoodsAns>, response: Response<FoodsAns>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<FoodsAns>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}


