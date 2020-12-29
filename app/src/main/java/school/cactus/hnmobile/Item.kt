package school.cactus.hnmobile

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Item(
    var title: String? = "",
    var type: String? = "",
    var url: String? = null,
    var score: Int? = 0,
    var author: String? = "",
    var time: Int? = 0
) {
}