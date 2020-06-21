package com.example.androidplayground.postlist.domain

import com.example.androidplayground.postlist.data.model.Post
import com.example.androidplayground.postlist.data.service.PostService
import com.example.androidplayground.shared.domain.UseCase

class GetPostList(private val postService: PostService) : UseCase<Int, List<Post>>() {

    override suspend fun execute(parameters: Int): List<Post> {
        return postService.getPosts(parameters)
    }
}