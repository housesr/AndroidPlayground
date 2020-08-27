package com.example.androidplayground.commentlist.presentation.viewmodel

import com.example.androidplayground.commentlist.domain.model.Comment
import com.example.androidplayground.commentlist.domain.usecase.GetCommentList
import com.example.androidplayground.commentlist.presentation.mapper.CommentToCommentUiModel
import com.github.michaelbull.result.Result
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK

class CommentListViewModelRobot {

    private val commentListViewModel: CommentListViewModel

    @MockK
    private lateinit var getCommentList: GetCommentList

    init {
        MockKAnnotations.init(this)

        commentListViewModel = CommentListViewModel(
            getCommentList = getCommentList,
            commentToCommentUiModel = CommentToCommentUiModel()
        ).apply {
            commentList.observeForever { }
            showEmpty.observeForever { }
        }
    }

    fun loadCommentList(result: Result<List<Comment>, Exception>) {
        coEvery { getCommentList(any()) } returns result
        commentListViewModel.loadCommentList(1)
    }

    infix fun verify(
        func: CommentListViewModelResultRobot.() -> Unit
    ) {
        CommentListViewModelResultRobot(commentListViewModel).func()
    }
}