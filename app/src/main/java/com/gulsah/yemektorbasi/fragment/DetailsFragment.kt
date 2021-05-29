package com.gulsah.yemektorbasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulsah.yemektorbasi.R
import com.gulsah.yemektorbasi.databinding.FragmentDetailsBinding
import com.gulsah.yemektorbasi.retrofit.ApiUtils
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {
    private lateinit var layout: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        layout.detailsFragment = this
        val bundle: DetailsFragmentArgs by navArgs()
        val foodObject = bundle.foodObject

        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${foodObject.yemek_resim_adi}")
            .into(layout.imageView)
        layout.textViewYemekAdi.text = foodObject.yemek_adi
        layout.textViewFiyat.text = "${foodObject.yemek_fiyat} ₺"

        return layout.root

    }

}