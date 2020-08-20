package com.example.androidplayground.postlist.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.asLiveData
import androidx.paging.PagingConfig
import com.example.androidplayground.postlist.domain.GetPaginatedPostList
import com.example.androidplayground.shared.presentation.BaseViewModel

class PostListViewModel @ViewModelInject constructor(
    getPaginatedPostList: GetPaginatedPostList
) : BaseViewModel() {

    val postList = getPaginatedPostList.invoke(
        GetPaginatedPostList.Parameters(
            PagingConfig(PAGE_SIZE)
        )
    ).asLiveData()

    companion object {
        private const val PAGE_SIZE = 10
    }
}