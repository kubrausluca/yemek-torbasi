package com.gulsah.yemektorbasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulsah.yemektorbasi.FoodAdapter
import com.gulsah.yemektorbasi.HomePageViewModel.HomePageViewModel
import com.gulsah.yemektorbasi.R
import com.gulsah.yemektorbasi.databinding.FragmentHomePageBinding
import com.gulsah.yemektorbasi.retrofit.ApiUtils
import com.gulsah.yemektorbasi.retrofit.FoodsDao

class HomePageFragment : Fragment() {

    //private lateinit var layout: FragmentHomePageBinding
    private lateinit var fdaoi: FoodsDao
    private lateinit var layout: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    private lateinit var adapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        fdaoi = ApiUtils.getFoodDao()
        layout.homePageFragment = this
        layout.rv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.foodsList.observe(viewLifecycleOwner) {
            adapter = FoodAdapter(requireContext(), it)
            layout.adapter = adapter
        }


        return layout.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: HomePageViewModel by viewModels()
        viewModel = temp
    }


}



