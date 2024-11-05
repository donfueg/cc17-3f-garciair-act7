package com.example.baguiorecow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val historyList: List<HistoryItem>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.historyTitle)
        val image: ImageView = itemView.findViewById(R.id.historyImage)
        val description: TextView = itemView.findViewById(R.id.historyDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentItem = historyList[position]
        holder.title.text = currentItem.title
        holder.image.setImageResource(currentItem.imageResId)
        holder.description.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}
