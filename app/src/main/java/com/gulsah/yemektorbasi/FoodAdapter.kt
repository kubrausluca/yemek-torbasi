package com.gulsah.yemektorbasi

import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.yemektorbasi.databinding.CardViewBinding


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
        val layout = CardViewBinding.inflate(layoutInflater,parent,false)
        return CardHolder(layout)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val food = foodList.get(position)

        holder.cardView.textViewFoodName.text = "${food.yemek_adi}"
        holder.cardView.textViewPrice.text = "${food.yemek_fiyat}"
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}