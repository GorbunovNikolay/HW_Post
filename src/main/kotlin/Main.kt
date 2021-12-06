import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    val original = Post(
        id = 1,
        owner_id = 1,
        from_id = 1,
     created_by  = 1,
     date  = 1,
     text = "original",
     reply_owner_id = 1,
     reply_post_id  = 1,
     friends_only  = 1,
     comments = Objects,
     copyright = Objects,
     likes  = Objects,
     reposts   = Objects,
     views    = Objects,
     post_type  = "original",
     signer_id   = 1,
     can_pin = true,
     can_delete  = false,
     can_edit   = true,
     is_pinned = 1,
     marked_as_ads    = false,
     is_favorite  = true,
     donut= Objects,
     postponed_id = 1
    )
}

class Post(
    val id : Int,
    val owner_id : Int,
    val from_id : Int,
    val created_by  : Int,
    val date  : Int,
    val text : String,
    val reply_owner_id : Int,
    val reply_post_id  : Int,
    val friends_only  : Int,
    val comments : Objects,
    val copyright : Objects,
    val likes  : Objects,
    val reposts   : Objects,
    val views    : Objects,
    val post_type  : String,
    val signer_id   : Int,
    val can_pin : Boolean,
    val can_delete  : Boolean,
    val can_edit   : Boolean,
    val is_pinned : Int,
    val marked_as_ads    : Boolean,
    val is_favorite  : Boolean,
    val donut: Objects,
    val postponed_id : Int
)

object WallService {
    private var posts = <Post>()
}
