package school.cactus.hnmobile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import school.cactus.hnmobile.NewStoriesAdapter.StoryItemHolder

class NewStoriesAdapter(options: FirebaseRecyclerOptions<Int>) :
    FirebaseRecyclerAdapter<Int, StoryItemHolder>(options) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoryItemHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return StoryItemHolder(view)
    }

    override fun onBindViewHolder(storyItemHolder: StoryItemHolder, position: Int, model: Int) {
        storyItemHolder.textView.text = model.toString()
    }

    class StoryItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}
