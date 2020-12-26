package school.cactus.hnmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val query = FirebaseDatabase.getInstance()
        .reference
        .child("/v0/topstories")
        .limitToLast(20)

    val options: FirebaseRecyclerOptions<Int> = FirebaseRecyclerOptions.Builder<Int>()
        .setQuery(query, Int::class.java)
        .build()

    val adapter = NewStoriesAdapter(options)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
}