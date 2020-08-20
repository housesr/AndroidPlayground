package com.example.androidplayground.commentlist.data.datasource

import com.example.androidplayground.commentlist.data.service.CommentService
import com.example.androidplayground.commentlist.domain.model.Comment
import javax.inject.Inject

class CommentDataSource @Inject constructor(
    private val commentService: CommentService
) {

    suspend fun getCommentList(postId: Int): List<Comment> =
        commentService.getComments(postId)
            .map { it.toComment() }
}