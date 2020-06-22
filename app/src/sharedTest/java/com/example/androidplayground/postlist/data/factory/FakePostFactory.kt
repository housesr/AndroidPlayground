package com.example.androidplayground.postlist.data.factory

import com.example.androidplayground.postlist.data.model.Post

object FakePostFactory {

    fun createPostList(): List<Post> {
        return listOf(
            Post(1, 1, "title", "body"),
            Post(1, 2, "title2", "body2")
        )
    }
}