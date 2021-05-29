package com.gulsah.yemektorbasi.HomePageViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsah.yemektorbasi.entity.Foods
import com.gulsah.yemektorbasi.repo.FoodDaoRepo

class HomePageViewModel: ViewModel() {
    var foodsList = MutableLiveData<List<Foods>>()
    val fdaor = FoodDaoRepo()
    init {
        foodLoad()
        foodsList = fdaor.foodGet()
    }

    private fun foodLoad() {
        fdaor.foodShow()
    }
}