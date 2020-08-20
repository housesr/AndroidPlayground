package com.example.androidplayground.commentlist.domain.factory

import com.example.androidplayground.commentlist.domain.model.Comment

object DomainCommentFactory {

    fun createCommentList(): List<Comment> =
        listOf(
            Comment(1, 1, "user01", "user01@email.com", "body1"),
            Comment(1, 2, "user02", "user02@email.com", "body2")
        )
}