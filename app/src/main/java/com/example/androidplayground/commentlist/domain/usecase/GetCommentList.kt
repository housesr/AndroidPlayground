package com.example.androidplayground.commentlist.domain.usecase

import com.example.androidplayground.commentlist.data.datasource.CommentDataSource
import com.example.androidplayground.commentlist.domain.model.Comment
import com.example.androidplayground.shared.domain.UseCase
import javax.inject.Inject

class GetCommentList @Inject constructor(
    private val commentDataSource: CommentDataSource
) : UseCase<Int, List<Comment>>() {

    override suspend fun execute(parameters: Int): List<Comment> {
        return commentDataSource.getCommentList(parameters)
    }
}