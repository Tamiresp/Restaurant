package com.example.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ReviewListAdapter : RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ReviewViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.review_item, parent, false)
    )

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ReviewViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }
}