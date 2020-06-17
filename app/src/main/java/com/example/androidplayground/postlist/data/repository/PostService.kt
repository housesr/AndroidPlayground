package com.example.androidplayground.postlist.data.repository

import com.example.androidplayground.postlist.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {

    @GET("posts")
    suspend fun getPosts(@Query("_page") page: Int): List<Post>
}