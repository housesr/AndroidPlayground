package com.example.androidplayground.postlist.data.service

import com.example.androidplayground.postlist.data.model.Post

class FakePostService : PostService {

    var postsResult: List<Post> = emptyList()

    override suspend fun getPosts(page: Int): List<Post> {
        return postsResult
    }
}