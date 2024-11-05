package com.example.baguiorecow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class NoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val continueButton = findViewById<Button>(R.id.Continue)

        backButton.setOnClickListener {
            finish()
        }

        continueButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
