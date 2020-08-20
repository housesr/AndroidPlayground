package com.example.androidplayground.postlist.data.service

import com.example.androidplayground.postlist.data.model.PostEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {

    @GET("posts")
    suspend fun getPosts(@Query("_page") page: Int): List<PostEntity>
}