package com.example.restaurant

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodDetailActivity : AppCompatActivity() {
    private val items = ArrayList<Reviews>()

    private val reviewsListAdapter = ReviewListAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        items.addAll(listOf(Reviews("sdas", "asdas"), Reviews("asjad", "asdag")))

        findViewById<RecyclerView>(R.id.reviews_list).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = reviewsListAdapter
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            dialog()
        }
    }

    private fun dialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.order_done)
        builder.setMessage(R.string.time)

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            goHome()
        }
        builder.show()
    }

    private fun goHome() {
        val mainIntent = Intent(this, HomeActivity::class.java)
        startActivity(mainIntent)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myIntent = Intent(applicationContext, HomeActivity::class.java)
        startActivityForResult(myIntent, 0)

        return super.onOptionsItemSelected(item)
    }
}