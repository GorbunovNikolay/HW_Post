import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами

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

        val MyCopyPost = Post(
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

        service.add(OriginalPost)
        service.add(MyCopyPost)

        // создаём информацию об обновлении
        val updateTrue = MyUpdatePostTrue

        // выполняем целевое действие
        var result = service.update(updateTrue)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)

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

        // создаём информацию об обновлении
        val updateFalse = MyUpdatePostFalse

        // выполняем целевое действие
        result = service.update(updateFalse)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)


    }
}