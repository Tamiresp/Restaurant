package com.example.restaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewListAdapter(var reviews: ArrayList<Reviews>) :
    RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ReviewViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.review_item, parent, false)
    )

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    override fun getItemCount() = reviews.size

    inner class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val personName = view.findViewById<TextView>(R.id.person_name)
        private val reviewText = view.findViewById<TextView>(R.id.person_review)

        fun bind(reviews: Reviews) {
            personName.text = reviews.personName
            reviewText.text = reviews.review
        }
    }
}