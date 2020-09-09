package com.example.androidplayground.postlist.data.mapper

import com.example.androidplayground.postlist.data.model.PostEntity
import com.example.androidplayground.postlist.domain.model.Post
import com.example.androidplayground.shared.mapper.Mapper
import javax.inject.Inject

class PostEntityToPost @Inject constructor() : Mapper<PostEntity, Post> {

    override suspend fun map(input: PostEntity): Post =
        input.run {
            Post(
                userId = userId!!,
                id = id!!,
                title = title ?: "",
                body = body ?: ""
            )
        }
}