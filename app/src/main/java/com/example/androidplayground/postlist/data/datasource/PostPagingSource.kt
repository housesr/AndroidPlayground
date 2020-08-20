package com.example.androidplayground.postlist.data.datasource

import androidx.paging.PagingSource
import com.example.androidplayground.postlist.data.model.Post
import com.example.androidplayground.postlist.data.service.PostService
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostPagingSource @Inject constructor(
    private val postService: PostService
) : PagingSource<Int, Post>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val nextKey = params.key ?: 0
            val response = postService.getPosts(nextKey)
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isEmpty()) null else nextKey + 1
            )
        } catch (e: Exception) {
            Timber.e(e)
            LoadResult.Error(e)
        }
    }
}