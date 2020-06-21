package com.example.androidplayground.postlist.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.androidplayground.postlist.data.model.Post
import com.example.androidplayground.postlist.domain.GetPostList
import com.example.androidplayground.shared.model.getOrDefault
import com.example.androidplayground.shared.presentation.BaseViewModel
import kotlinx.coroutines.launch

class PostListViewModel(
    private val getPostList: GetPostList
) : BaseViewModel() {

    private val _postList = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>> = _postList

    val showEmpty: LiveData<Boolean> = _postList.map { it.isEmpty() }

    fun loadPostList() {
        viewModelScope.launch {
            showLoading()
            _postList.value = getPostList(1).getOrDefault(emptyList())
            hideLoading()
        }
    }
}