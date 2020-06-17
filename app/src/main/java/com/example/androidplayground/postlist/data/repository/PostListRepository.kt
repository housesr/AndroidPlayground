package com.example.androidplayground.postlist.data.repository

import com.example.androidplayground.postlist.data.model.Post

class PostListRepository(private val postService: PostService) {

    suspend fun getPostList(page: Int): List<Post> {
        return postService.getPosts(page)
    }
}