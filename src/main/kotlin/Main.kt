
fun main() {
    val myCommentOriginal = Comment(2, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    val myCopyrightOriginal = Copyright(12, "Текстовая ссылка", "Мой копирайт", "Мой тип копирайта")
    val myLikesOriginal = Like(24, userLikes = true, canLike = true, canPublish = false)
    val myRepostsOriginal = Repost(4, user_reposted = true)
    val myViewsOriginal = View(122)
    val myDonutOriginal = Donut(false, 86400, false, "all")
    val myPostSource = PostSource("vk", "android", "profile_activity", "https://www.vk.com")
    val myPlace = Place("1", "Дом", 55.651940, 37.617826, 1639167144, "place.png",
        2, 1399167144, 1, 7, 77, "Некая ул.")
    val myGeo = Geo("Дом", "55.651940, 37.617826", myPlace)

    val originalPost = Post(
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 1,
        text = "original",
        replyOwnerId = 1,
        replyPostId = 1,
        friendsOnly = 1,
        comments = myCommentOriginal,
        copyright = myCopyrightOriginal,
        likes = myLikesOriginal,
        reposts = myRepostsOriginal,
        views = myViewsOriginal,
        postType = "original",
        postSource = myPostSource,
        attachments = emptyArray<Attachment>(),
        geo = myGeo,
        copyHistory = emptyArray<Post>(),
        signerId = 1,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 1,
        markedAsAds = false,
        isFavorite = true,
        donut = myDonutOriginal,
        postponedId = 1
    )

    val myCommentCopy = Comment(4, canPost = false, groupsCanPost = false, canClose = false, canOpen = false)
    val myCopyrightCopy = Copyright(24, "Текстовая ссылка копии", "Мой копирайт копии", "Мой тип копирайта копии")
    val myLikesCopy = Like(48, userLikes = false, canLike = false, canPublish = true)
    val myRepostsCopy = Repost(8, user_reposted = false)
    val myViewsCopy = View(244)
    val myDonutCopy = Donut(true, 86400 * 2, true, "duration")
    val myPostSourceCopy = PostSource("widget", "iphone", "comments", "https://www.vk.com/copynews")
    val myPlaceCopy = Place("2", "Работа", 55.751953, 37.717029, 1529167267, "copyPlace.png",
        7, 1536168293, 2, 7, 77, "Спортивная ул.")
    val myGeoCopy = Geo("Работа", "55.751953, 37.717029", myPlaceCopy)

    val copyPost = Post(
        ownerId = 2,
        fromId = 2,
        createdBy = 2,
        date = 2,
        text = "copy",
        replyOwnerId = 2,
        replyPostId = 2,
        friendsOnly = 2,
        comments = myCommentCopy,
        copyright = myCopyrightCopy,
        likes = myLikesCopy,
        reposts = myRepostsCopy,
        views = myViewsCopy,
        postType = "copy",
        postSource = myPostSourceCopy,
        geo = myGeoCopy,
        copyHistory = emptyArray<Post>(),
        signerId = 2,
        canPin = false,
        canDelete = true,
        canEdit = false,
        isPinned = 2,
        markedAsAds = true,
        isFavorite = false,
        donut = myDonutCopy,
        postponedId = 2
    )

    val myCommentUpdate = Comment(55, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    val myCopyrightUpdate = Copyright(55, "Текстовая ссылка обновления", "Мой копирайт обновление", "Мой тип копирайта обновление")
    val myLikesUpdate = Like(55, userLikes = true, canLike = true, canPublish = false)
    val myRepostsUpdate = Repost(55, user_reposted = true)
    val myViewsUpdate = View(555)
    val myDonutUpdate = Donut(false, 555555, false, "all")
    val myPostSourceUpdate = PostSource("api", "wphone", "", "https://www.vk.com/update")
    val myPlaceUpdate = Place("3", "Дача", 55.751541, 37.619825, 143917721, "dacha.png",
        3, 1439167241, 3, 7, 50, "Летняя ул.")
    val myGeoUpdate = Geo("Дача", "55.751541, 37.619825", myPlaceUpdate)

    val myUpdatePostTrue = Post(
        id = 2,
        ownerId = 55,
        fromId = 55,
        createdBy = 55,
        date = 55,
        text = "update",
        replyOwnerId = 55,
        replyPostId = 55,
        friendsOnly = 55,
        comments = myCommentUpdate,
        copyright = myCopyrightUpdate,
        likes = myLikesUpdate,
        reposts = myRepostsUpdate,
        views = myViewsUpdate,
        postType = "update",
        postSource = myPostSourceUpdate,
        attachments = emptyArray<Attachment>(),
        geo = myGeoUpdate,
        copyHistory = emptyArray<Post>(),
        signerId = 55,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 55,
        markedAsAds = false,
        isFavorite = true,
        donut = myDonutUpdate,
        postponedId = 55
    )

    val myUpdatePostFalse = Post(
        id = 30,
        ownerId = 55,
        fromId = 55,
        createdBy = 55,
        date = 55,
        text = "update",
        replyOwnerId = 55,
        replyPostId = 55,
        friendsOnly = 55,
        comments = myCommentUpdate,
        copyright = myCopyrightUpdate,
        likes = myLikesUpdate,
        reposts = myRepostsUpdate,
        views = myViewsUpdate,
        postType = "update",
        postSource = myPostSourceUpdate,
        geo = myGeoUpdate,
        copyHistory = emptyArray<Post>(),
        signerId = 55,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 55,
        markedAsAds = false,
        isFavorite = true,
        donut = myDonutUpdate,
        postponedId = 55
    )


    WallService.add(originalPost)
    WallService.add(copyPost)

    var result = WallService.update(myUpdatePostTrue)
    if (result) println("Пост найден, пост обновлен") else println("Пост не найден")

    result = WallService.update(myUpdatePostFalse)
    if (result) println("Пост найден, пост обновлен") else println("Пост не найден")

    val sizeWallService = WallService.posts.size
    println("Количество элементов в массиве типа Post: $sizeWallService")

}

fun getUniqueId(posts: Array<Post>): Int {
    if (posts.isEmpty()) return 1

    return posts.last().id + 1
}

