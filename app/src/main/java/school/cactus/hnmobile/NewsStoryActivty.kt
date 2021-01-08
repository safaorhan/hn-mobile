package school.cactus.hnmobile

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class NewsStoryActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_story_activty)

        val url = intent.extras!!.get("newdescrip").toString()
        val myWebView = WebView(this)
        setContentView(myWebView)
        myWebView.loadUrl(url)
    }
}