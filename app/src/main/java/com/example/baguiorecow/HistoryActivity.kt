package com.example.baguiorecow

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        // Set up the back button
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // This will close the current activity and return to the previous one
        }

        recyclerView = findViewById(R.id.recyclerViewHistory)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load history items
        val historyItems = loadHistoryItems()
        adapter = HistoryAdapter(historyItems)
        recyclerView.adapter = adapter
    }

    private fun loadHistoryItems(): List<HistoryItem> {
        return listOf(
            HistoryItem("History of Baguio", R.drawable.history, "Baguio City, known as the Summer Capital of the Philippines, was established as a military base in the 1900s."),
            HistoryItem("Cultural Heritage", R.drawable.cult, "Baguio is famous for its rich cultural heritage and colorful festivals, including the Panagbenga Festival."),
            HistoryItem("Tourism", R.drawable.tour, "Baguio attracts millions of visitors yearly, thanks to its cool climate and beautiful scenery.")
        )
    }
}
