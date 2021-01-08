package school.cactus.hnmobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import school.cactus.hnmobile.NewStoriesAdapter.StoryItemHolder

class NewStoriesAdapter(
    options: FirebaseRecyclerOptions<Int>
) :
    FirebaseRecyclerAdapter<Int, StoryItemHolder>(options) {

    val itemMap = mutableMapOf<Int, Item>()

    private val query = Firebase.database.reference
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryItemHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return StoryItemHolder(view)
    }

    override fun onBindViewHolder(storyItemHolder: StoryItemHolder, position: Int, model: Int) {

        val queryStory = query.child("/v0/item/$model")

        if (itemMap.containsKey(model)) {
            storyItemHolder.textView.text = "News: ${itemMap[model]!!.title}"
            storyItemHolder.bindTo(itemMap[model]!!)
        } else {
            storyItemHolder.textView.text = "Loading..."

            queryStory.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(snapshot: DataSnapshot) {

                    val newsItem = snapshot.getValue<Item>()!!
                    itemMap[newsItem.id] = newsItem
                    storyItemHolder.textView.text = "News: ${newsItem.title}"

                }
            })
        }

    }


    class StoryItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById(R.id.textView)
        fun bindTo(item: Item) {
            textView.setOnClickListener {

                val intent = Intent(it.context, NewsStoryActivty::class.java)

                //Detail sayfasına gonderdigimiz verileri put extra kullanarak göndericez.

                intent.putExtra("newdescrip", item.url)


                it.context.startActivity(intent)

            }

        }

    }
}
