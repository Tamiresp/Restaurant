package com.example.restaurant

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(var food: ArrayList<Food>, context: Context) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private val context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
    )

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(food[position])

        holder.card.setOnClickListener {
            val intent = Intent(context, FoodDetailActivity::class.java).apply {
                putExtra("name", holder.foodName.text)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = food.size

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodName: TextView = view.findViewById(R.id.name)
        val card: CardView = view.findViewById(R.id.cardView)

        fun bind(food: Food) {
            foodName.text = food.name
        }
    }
}