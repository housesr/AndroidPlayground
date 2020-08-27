package com.example.androidplayground.commentlist.presentation.mapper

import com.example.androidplayground.commentlist.domain.model.Comment
import com.example.androidplayground.commentlist.presentation.model.CommentUiModel
import com.example.androidplayground.shared.mapper.Mapper
import javax.inject.Inject

class CommentToCommentUiModel @Inject constructor() : Mapper<Comment, CommentUiModel> {

    override suspend fun map(input: Comment): CommentUiModel =
        input.run {
            CommentUiModel(
                id = id,
                name = name,
                body = body
            )
        }
}