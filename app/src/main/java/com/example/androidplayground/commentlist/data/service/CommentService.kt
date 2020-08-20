package com.example.androidplayground.commentlist.data.service

import com.example.androidplayground.commentlist.data.model.CommentEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentService {

    @GET("comments")
    suspend fun getComments(@Query("postId") postId: Int): List<CommentEntity>
}