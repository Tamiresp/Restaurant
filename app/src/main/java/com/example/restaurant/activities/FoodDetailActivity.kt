package com.example.restaurant.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.R
import com.example.restaurant.Reviews
import com.example.restaurant.adapters.ReviewListAdapter

class FoodDetailActivity : AppCompatActivity() {
    private val items = ArrayList<Reviews>()

    private val reviewsListAdapter = ReviewListAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val intent = intent
        val name: String? = intent.getStringExtra("name")
        val price: String? = intent.getStringExtra("price")
        val desc: String? = intent.getStringExtra("description")
        val img = intent.getIntExtra("img", 0)

        supportActionBar?.title = name

        items.addAll(
            listOf(
                Reviews("Maria", "Excelente, muito saboroso!"),
                Reviews("João", "um dos melhores que já provei!")
            )
        )

        findViewById<TextView>(R.id.food_title).text = name
        findViewById<TextView>(R.id.priceDetail).text = price
        findViewById<TextView>(R.id.description_food).text = desc
        findViewById<ImageView>(R.id.food_image).setImageDrawable(getDrawable(img))

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