data class Comment(
    val postId: Int,
    val count: Int,
    val message: String,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)