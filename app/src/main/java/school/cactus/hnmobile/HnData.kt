package school.cactus.hnmobile

import android.net.UrlQuerySanitizer
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.net.URL

@IgnoreExtraProperties
data class HnData(
    var title: String? = "",
    var type: String? = "",
    var url: URL? = null,
    var score: Int? = 0,
    var author: String? = "",
    var time: Int? = 0
) {
}