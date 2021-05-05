package com.example.restaurant

import android.graphics.drawable.Drawable

data class Food(
    val name: String,
    val img: Drawable,
    val price: String,
    val desc: String
)