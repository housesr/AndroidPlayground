package com.example.androidplayground.postlist.presentation.ui

//import androidx.test.core.app.launchActivity
//import com.example.androidplayground.MainActivity
//import com.example.androidplayground.postlist.data.model.PostEntity
//import com.example.androidplayground.postlist.data.service.FakePostService
//
//class PostListRobot(private val postService: FakePostService) {
//
//    fun postList(list: List<PostEntity>) {
//        postService.postsResult = list
//    }
//
//    inline infix fun launch(func: PostListResultRobot.() -> Unit): PostListResultRobot {
//        launchActivity<MainActivity>()
//        return PostListResultRobot().apply { func() }
//    }
//}
//
//inline fun postListRobot(
//    postService: FakePostService,
//    func: PostListRobot.() -> Unit
//) = PostListRobot(postService).apply { func() }