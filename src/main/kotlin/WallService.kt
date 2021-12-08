object WallService {
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val copyPost = post.copy(id = getUniqueId(posts))
        posts += copyPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                val updatePost = post.copy(
                    ownerId = value.ownerId,
                    date = value.date
                )
                posts[index] = updatePost
                return true
            }
        }
        return false
    }
}