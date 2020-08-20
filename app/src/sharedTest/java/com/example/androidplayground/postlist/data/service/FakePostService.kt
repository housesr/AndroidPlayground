package com.example.androidplayground.postlist.data.service

import com.example.androidplayground.postlist.data.model.PostEntity

class FakePostService : PostService {

    var postsResult: List<PostEntity> = emptyList()

    override suspend fun getPosts(page: Int): List<PostEntity> {
        return postsResult
    }
}