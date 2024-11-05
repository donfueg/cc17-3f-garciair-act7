package com.example.baguiorecow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val yesActButton = findViewById<Button>(R.id.YesButton)
        val noButton = findViewById<Button>(R.id.buttonNo) // Reference to No button

        yesActButton.setOnClickListener {
            val intent = Intent(this, YesActivity::class.java)
            startActivity(intent)
        }

        noButton.setOnClickListener {
            // Define what happens when the No button is clicked
            val intent = Intent(this, NoActivity::class.java) // Change to your desired activity
            startActivity(intent)
        }
    }
}
