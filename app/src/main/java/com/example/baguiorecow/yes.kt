package com.example.baguiorecow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class YesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yes)

        val cardCoffeeShops: CardView = findViewById(R.id.cardCoffeeShops)
        val cardGym: CardView = findViewById(R.id.cardGym)
        val cardBar: CardView = findViewById(R.id.cardBar)
        val cardPark: CardView = findViewById(R.id.cardPark)
        val cardRestaurant: CardView = findViewById(R.id.cardRestaurant)
        val cardTouristSpots: CardView = findViewById(R.id.cardTouristSpots)
        val cardEvents: CardView = findViewById(R.id.cardEvents)

        cardCoffeeShops.setOnClickListener {
            startRecommendationActivity("Coffee Shops")
        }
        cardGym.setOnClickListener {
            startRecommendationActivity("Gyms")
        }
        cardBar.setOnClickListener {
            startRecommendationActivity("Bars")
        }
        cardPark.setOnClickListener {
            startRecommendationActivity("Parks")
        }
        cardRestaurant.setOnClickListener {
            startRecommendationActivity("Restaurants")
        }
        cardTouristSpots.setOnClickListener {
            startRecommendationActivity("Tourist Spots")
        }
        cardEvents.setOnClickListener {
            startRecommendationActivity("Events")
        }
    }

    private fun startRecommendationActivity(category: String) {
        val intent = Intent(this, RecommendationActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}
