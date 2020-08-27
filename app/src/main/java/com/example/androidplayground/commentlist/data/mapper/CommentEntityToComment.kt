package com.example.androidplayground.commentlist.data.mapper

import com.example.androidplayground.commentlist.data.model.CommentEntity
import com.example.androidplayground.commentlist.domain.model.Comment
import com.example.androidplayground.shared.mapper.Mapper
import javax.inject.Inject

class CommentEntityToComment @Inject constructor() : Mapper<CommentEntity, Comment> {

    override suspend fun map(input: CommentEntity): Comment =
        input.run {
            Comment(
                postId = postId!!,
                id = id!!,
                name = name ?: "",
                email = email ?: "",
                body = body ?: ""
            )
        }
}