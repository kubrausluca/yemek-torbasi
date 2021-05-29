package com.gulsah.yemektorbasi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.yemektorbasi.databinding.CardViewBinding
import com.gulsah.yemektorbasi.entity.Foods
import com.squareup.picasso.Picasso


class FoodAdapter(var mContext: Context, var foodList: List<Foods>) :
    RecyclerView.Adapter<FoodAdapter.CardHolder>() {

    inner class CardHolder(cardViewBinding: CardViewBinding) :
        RecyclerView.ViewHolder(cardViewBinding.root) {
        var cardView: CardViewBinding

        init {
            this.cardView = cardViewBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val layout = CardViewBinding.inflate(layoutInflater, parent, false)
        return CardHolder(layout)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val food = foodList.get(position)
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}")
            .into(holder.cardView.imageViewYemekResim)
        holder.cardView.foodObject = food

    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}