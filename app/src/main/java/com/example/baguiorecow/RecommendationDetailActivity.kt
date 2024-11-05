package com.example.baguiorecow

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecommendationDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation_detail)

        val nameTextView = findViewById<TextView>(R.id.recommendationDetailName)
        val imageView1 = findViewById<ImageView>(R.id.recommendationImage1)
        val imageView2 = findViewById<ImageView>(R.id.recommendationImage2)
        val imageView3 = findViewById<ImageView>(R.id.recommendationImage3)
        val infoTextView = findViewById<TextView>(R.id.recommendationDetailInfo)
        val backButton = findViewById<ImageButton>(R.id.backButton)


        val name = intent.getStringExtra("RECOMMENDATION_NAME") ?: "No Name Provided"
        val images = intent.getIntegerArrayListExtra("RECOMMENDATION_IMAGES") ?: arrayListOf()
        val info = intent.getStringExtra("RECOMMENDATION_DESCRIPTION") ?: "No description available"

        Log.d("RecommendationDetail", "Name: $name, Info: $info, Images: $images")

        nameTextView.text = name
        infoTextView.text = info

        if (images.isNotEmpty()) imageView1.setImageResource(images[0])
        if (images.size > 1) imageView2.setImageResource(images[1])
        if (images.size > 2) imageView3.setImageResource(images[2])

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
