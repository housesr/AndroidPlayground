package com.example.androidplayground.postlist.presentation.mapper

import com.example.androidplayground.postlist.domain.model.Post
import com.example.androidplayground.postlist.presentation.model.PostUiModel
import com.example.androidplayground.shared.mapper.Mapper
import javax.inject.Inject

class PostToPostUiModel @Inject constructor() : Mapper<Post, PostUiModel> {

    override suspend fun map(input: Post): PostUiModel =
        input.run {
            PostUiModel(
                id = id,
                title = title ?: "",
                body = body ?: ""
            )
        }
}