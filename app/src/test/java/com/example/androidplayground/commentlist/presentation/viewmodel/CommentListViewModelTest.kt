package com.example.androidplayground.commentlist.presentation.viewmodel

import com.example.androidplayground.commentlist.domain.factory.DomainCommentFactory
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CommentListViewModelTest {

    private lateinit var commentListViewModelRobot: CommentListViewModelRobot

    @Before
    fun setUp() {
        commentListViewModelRobot = CommentListViewModelRobot()
    }

    @Test
    fun `show empty when loading comment list succeeds`() {
        robot {
            loadCommentList(
                Ok(
                    emptyList()
                )
            )
        } verify {
            shouldNotShowCommentList()
            shouldShowEmpty()
            shouldNotShowError()
            shouldNotShowLoading()
        }
    }

    @Test
    fun `show comment list when loading comment list succeeds`() {
        robot {
            loadCommentList(
                Ok(
                    DomainCommentFactory.createCommentList()
                )
            )
        } verify {
            shouldShowCommentList()
            shouldNotShowEmpty()
            shouldNotShowError()
            shouldNotShowLoading()
        }
    }

    @Test
    fun `show error when loading comment list fails`() {
        robot {
            loadCommentList(
                Err(
                    Exception()
                )
            )
        } verify {
            shouldNotShowCommentList()
            shouldNotShowEmpty()
            shouldShowError()
            shouldNotShowLoading()
        }
    }

    private fun robot(
        func: CommentListViewModelRobot.() -> Unit
    ): CommentListViewModelRobot = commentListViewModelRobot.apply { func() }
}