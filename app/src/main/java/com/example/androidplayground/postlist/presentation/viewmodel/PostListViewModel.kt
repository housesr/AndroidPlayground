package com.example.androidplayground.postlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androidplayground.postlist.data.repository.PostListRepository

class PostListViewModel(
    private val postListRepository: PostListRepository
) : ViewModel() {

    fun loadPostList() {
    }
}