package com.example.androidplayground.commentlist.presentation.viewmodel

import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEqualTo

class CommentListViewModelResultRobot(
    private val commentListViewModel: CommentListViewModel
) {

    fun shouldNotShowCommentList() {
        commentListViewModel.commentList.value?.isNotEmpty() ?: false shouldNotBeEqualTo true
    }

    fun shouldShowCommentList() {
        commentListViewModel.commentList.value!!.isNotEmpty() shouldBeEqualTo true
    }

    fun shouldShowEmpty() {
        commentListViewModel.showEmpty.value shouldBeEqualTo true
    }

    fun shouldNotShowEmpty() {
        commentListViewModel.showEmpty.value shouldNotBeEqualTo true
    }

    fun shouldShowError() {
        commentListViewModel.error.value shouldNotBeEqualTo null
    }

    fun shouldNotShowError() {
        commentListViewModel.error.value shouldBeEqualTo null
    }

    fun shouldNotShowLoading() {
        commentListViewModel.loading.value shouldNotBeEqualTo true
    }
}