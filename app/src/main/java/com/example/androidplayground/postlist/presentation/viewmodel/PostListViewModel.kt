package com.example.androidplayground.postlist.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.androidplayground.postlist.presentation.mapper.PostToPostUiModel
import com.example.androidplayground.postlist.domain.usecase.GetPaginatedPostList
import com.example.androidplayground.shared.presentation.BaseViewModel
import kotlinx.coroutines.flow.map

class PostListViewModel @ViewModelInject constructor(
    getPaginatedPostList: GetPaginatedPostList,
    private val postToPostUiModel: PostToPostUiModel
) : BaseViewModel() {

    val postList = getPaginatedPostList.invoke(
        GetPaginatedPostList.Parameters(
            PagingConfig(PAGE_SIZE)
        )
    )
        .map { pagingData ->
            pagingData.map { post ->
                postToPostUiModel.map(post)
            }
        }
        .asLiveData()
        .cachedIn(viewModelScope)

    companion object {
        private const val PAGE_SIZE = 10
    }
}