package com.example.androidplayground.postlist.data.service

import com.example.androidplayground.postlist.data.model.Post

// TODO("Move to shared test")
class FakePostService : PostService {

    override suspend fun getPosts(page: Int): List<Post> {
        return listOf(
            Post(1, 1, "title", "body"),
            Post(1, 2, "title2", "body2")
        )
    }
}