import java.util.*

fun main() {
    val MyCommentOriginal = Comment(2, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    val MyCopyrightOriginal = Copyright(12, "Текстовая ссылка", "Мой копирайт", "Мой тип копирайта")
    val MyLikesOriginal = Like(24, userLikes = true, canLike = true, canPublish = false)
    val MyRepostsOriginal = Repost(4, user_reposted = true)
    val MyViewsOriginal = View(122)
    val MyDonutOriginal = Donut(false, 86400, false, "all")

    val OriginalPost = Post(
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "original",
        replyOwnerId = 1,
        replyPostId = 1,
        friendsOnly = 1,
        comments = MyCommentOriginal,
        copyright = MyCopyrightOriginal,
        likes = MyLikesOriginal,
        reposts = MyRepostsOriginal,
        views = MyViewsOriginal,
        postType = "original",
        signerId = 1,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 1,
        markedAsAds = false,
        isFavorite = true,
        donut = MyDonutOriginal,
        postponedId = 1
    )

    val MyCommentCopy = Comment(4, canPost = false, groupsCanPost = false, canClose = false, canOpen = false)
    val MyCopyrightCopy = Copyright(24, "Текстовая ссылка копии", "Мой копирайт копии", "Мой тип копирайта копии")
    val MyLikesCopy = Like(48, userLikes = false, canLike = false, canPublish = true)
    val MyRepostsCopy = Repost(8, user_reposted = false)
    val MyViewsCopy = View(244)
    val MyDonutCopy = Donut(true, 86400 * 2, true, "duration")

    val CopyPost = Post(
        ownerId = 2,
        fromId = 2,
        createdBy = 2,
        date = 2,
        text = "copy",
        replyOwnerId = 2,
        replyPostId = 2,
        friendsOnly = 2,
        comments = MyCommentCopy,
        copyright = MyCopyrightCopy,
        likes = MyLikesCopy,
        reposts = MyRepostsCopy,
        views = MyViewsCopy,
        postType = "copy",
        signerId = 2,
        canPin = false,
        canDelete = true,
        canEdit = false,
        isPinned = 2,
        markedAsAds = true,
        isFavorite = false,
        donut = MyDonutCopy,
        postponedId = 2
    )

    val MyCommentUpdate = Comment(55, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    val MyCopyrightUpdate = Copyright(55, "Текстовая ссылка обновления", "Мой копирайт обновление", "Мой тип копирайта обновление")
    val MyLikesUpdate = Like(55, userLikes = true, canLike = true, canPublish = false)
    val MyRepostsUpdate = Repost(55, user_reposted = true)
    val MyViewsUpdate = View(555)
    val MyDonutUpdate = Donut(false, 555555, false, "all")

    val MyUpdatePostTrue = Post(
        id = 2,
        ownerId = 55,
        fromId = 55,
        createdBy = 55,
        date = 55,
        text = "update",
        replyOwnerId = 55,
        replyPostId = 55,
        friendsOnly = 55,
        comments = MyCommentUpdate,
        copyright = MyCopyrightUpdate,
        likes = MyLikesUpdate,
        reposts = MyRepostsUpdate,
        views = MyViewsUpdate,
        postType = "update",
        signerId = 55,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 55,
        markedAsAds = false,
        isFavorite = true,
        donut = MyDonutUpdate,
        postponedId = 55
    )

    val MyUpdatePostFalse = Post(
        id = 30,
        ownerId = 55,
        fromId = 55,
        createdBy = 55,
        date = 55,
        text = "update",
        replyOwnerId = 55,
        replyPostId = 55,
        friendsOnly = 55,
        comments = MyCommentUpdate,
        copyright = MyCopyrightUpdate,
        likes = MyLikesUpdate,
        reposts = MyRepostsUpdate,
        views = MyViewsUpdate,
        postType = "update",
        signerId = 55,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 55,
        markedAsAds = false,
        isFavorite = true,
        donut = MyDonutUpdate,
        postponedId = 55
    )


    WallService.add(OriginalPost)
    WallService.add(CopyPost)

    var result = WallService.update(MyUpdatePostTrue)
    if (result) println("Пост найден, пост обновлен") else println("Пост не найден")

    result = WallService.update(MyUpdatePostFalse)
    if (result) println("Пост найден, пост обновлен") else println("Пост не найден")

    val sizeWallService = WallService.posts.size
    println("Количество элементов в массиве типа Post: $sizeWallService")

}

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Int,
    val comments: Comment,
    val copyright: Copyright,
    val likes: Like,
    val reposts: Repost,
    val views: View,
    val postType: String,
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

data class Comment(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Like(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Repost(
    val count: Int,
    val user_reposted: Boolean
)

data class View(
    val count: Int
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    //val placeholder : Objects,    //к сожалению не нашёл описание данного объекта
    val canPublishFreeCopy: Boolean,
    val edit_mode: String
)

fun getUniqueId(Posts: Array<Post>): Int {
    var maxId = 0
    for (Post in Posts) {
        if (Post.id > maxId) {
            maxId = Post.id
        }
    }
    return maxId + 1
}

object WallService {
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val CopyPost = post.copy(id = getUniqueId(posts))
        posts += CopyPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                val UpdatePost = post.copy(
                    ownerId = value.ownerId,
                    date = value.date
                )
                posts[index] = UpdatePost
                return true
            }
        }
        return false
    }
}
