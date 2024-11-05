import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baguiorecow.R
import com.example.baguiorecow.Recommendation

class RecommendationAdapter(
    private val recommendations: List<Recommendation>,
    private val onClick: (Recommendation) -> Unit
) : RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {

    inner class RecommendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.recommendationName)
        private val imageView: ImageView = itemView.findViewById(R.id.recommendationImage)

        fun bind(recommendation: Recommendation) {
            nameTextView.text = recommendation.name
            imageView.setImageResource(recommendation.images[0]) // Display the first image from the list
            itemView.setOnClickListener {
                onClick(recommendation)
            }
        }
    }
//change 1
    //change 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendation, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun getItemCount(): Int = recommendations.size
}
