package com.example.restaurant.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.Food
import com.example.restaurant.activities.FoodDetailActivity
import com.example.restaurant.R

class FoodAdapter(var food: ArrayList<Food>, context: Context) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private val context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
    )

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(food[position])
        val item = food[position]

        holder.card.setOnClickListener {
            val intent = Intent(context, FoodDetailActivity::class.java).apply {
                putExtra("name", holder.foodName.text)
//                putExtra("img", holder.imgHamb.drawable)
                putExtra("price", holder.price.text)
                putExtra("description", item.desc)

            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = food.size

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodName: TextView = view.findViewById(R.id.name)
        val card: CardView = view.findViewById(R.id.cardView)
        val imgHamb: ImageView = view.findViewById(R.id.imageView)
        val price: TextView = view.findViewById(R.id.price)

        fun bind(food: Food) {
            foodName.text = food.name
            imgHamb.setImageDrawable(food.img)
            price.text = food.price
        }
    }
}