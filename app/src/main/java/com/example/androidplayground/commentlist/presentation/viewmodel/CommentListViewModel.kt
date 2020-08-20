package com.example.androidplayground.commentlist.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.androidplayground.commentlist.domain.usecase.GetCommentList
import com.example.androidplayground.commentlist.presentation.mapper.CommentToCommentUiModel
import com.example.androidplayground.commentlist.presentation.model.CommentUiModel
import com.example.androidplayground.shared.presentation.BaseViewModel
import com.github.michaelbull.result.map
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import kotlinx.coroutines.launch

class CommentListViewModel @ViewModelInject constructor(
    private val getCommentList: GetCommentList,
    private val commentToCommentUiModel: CommentToCommentUiModel
) : BaseViewModel() {

    private val _commentList = MutableLiveData<List<CommentUiModel>>()
    val commentList: LiveData<List<CommentUiModel>> = _commentList

    val showEmpty = commentList.map { it.isEmpty() }

    fun loadCommentList(postId: Int) {
        viewModelScope.launch {
            showLoading()

            getCommentList(postId)
                .map { commentList ->
                    commentList.map { comment ->
                        commentToCommentUiModel.map(comment)
                    }
                }
                .onSuccess { _commentList.value = it }
                .onFailure { showError(it) }

            hideLoading()
        }
    }
}