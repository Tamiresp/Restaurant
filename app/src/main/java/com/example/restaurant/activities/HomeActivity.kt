package com.example.restaurant.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.Food
import com.example.restaurant.R
import com.example.restaurant.adapters.FoodAdapter


class HomeActivity : AppCompatActivity() {
    private val foods = ArrayList<Food>()
    private val drinks = ArrayList<Food>()

    private val foodsListAdapter = FoodAdapter(foods, this)
    private val drinksListAdapter = FoodAdapter(drinks, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        foods.addAll(
            listOf(
                Food(
                    "X-Frango",
                    R.drawable.x_frango,
                    "R$20,00",
                    getString(R.string.x_frango_text)
                ),
                Food(
                    "Picanha",
                    R.drawable.supremo,
                    "R$28,00",
                    getString(R.string.picanha_text)
                ),
                Food(
                    "Junior",
                    R.drawable.junior,
                    "R$16,00",
                    getString(R.string.junior_text)
                )
            )
        )
        drinks.addAll(
            listOf(
                Food(
                    "Refrigerante",
                    R.drawable.refrigerante,
                    "R$6,00",
                    getString(R.string.refri_text)
                ),
                Food(
                    "Drinks",
                    R.drawable.drinks2,
                    "R$13,00",
                    getString(R.string.drink_text)
                ),
                Food(
                    "Cervejas",
                    R.drawable.cerveja,
                    "R$7,00",
                    getString(R.string.cerveja_text)
                )
            )
        )

        findViewById<RecyclerView>(R.id.hamburg_list).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = foodsListAdapter
        }

        findViewById<RecyclerView>(R.id.drinks_list).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = drinksListAdapter
        }
    }
}