data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Int,
    val comments: Comment?,
    val copyright: Copyright,
    val likes: Like,
    val reposts: Repost?,
    val views: View,
    val postType: String,
    val postSource: PostSource,
    val attachments: Array<Attachment>? = null,
    val geo: Geo,
    val copyHistory: Array<Post>,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Int,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int
)