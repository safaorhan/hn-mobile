package school.cactus.hnmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    val news = listOf(
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)",
        "Free tool that automates steps security would take to discover data exposure (gretel.ai)"
    )

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_news, viewGroup, false)
        return NewsHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: NewsHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = news[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = news.size

}