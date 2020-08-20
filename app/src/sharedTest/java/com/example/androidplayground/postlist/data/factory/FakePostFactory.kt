package com.example.androidplayground.postlist.data.factory

import com.example.androidplayground.postlist.data.model.PostEntity

object FakePostFactory {

    fun createPostList(): List<PostEntity> {
        return listOf(
            PostEntity(1, 1, "title", "body"),
            PostEntity(1, 2, "title2", "body2")
        )
    }
}