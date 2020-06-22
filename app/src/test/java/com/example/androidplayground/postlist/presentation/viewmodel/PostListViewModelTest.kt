package com.example.androidplayground.postlist.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidplayground.postlist.data.factory.FakePostFactory
import com.example.androidplayground.postlist.data.service.FakePostService
import com.example.androidplayground.postlist.data.service.PostService
import com.example.androidplayground.postlist.fakePostModule
import com.example.androidplayground.shared.di.appModule
import com.example.androidplayground.shared.rule.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class PostListViewModelTest : KoinTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val postListViewModel: PostListViewModel by inject()
    private val postService: PostService by inject()

    @Before
    fun setup() {
        startKoin {
            modules(appModule, fakePostModule)
        }

        postListViewModel.run {
            postList.observeForever { }
            showEmpty.observeForever { }
        }
    }

    @Test
    fun show_empty_when_loadPostList_returns_empty_post_list() {
        (postService as FakePostService).postsResult = emptyList()

        postListViewModel.loadPostList()

        assertThat(postListViewModel.postList.value).hasSize(0)
        assertThat(postListViewModel.showEmpty.value).isTrue()
    }

    @Test
    fun do_not_show_empty_when_loadPostList_returns_post_list() {
        (postService as FakePostService).postsResult = FakePostFactory.createPostList()

        postListViewModel.loadPostList()

        assertThat(postListViewModel.postList.value).hasSize(2)
        assertThat(postListViewModel.showEmpty.value).isFalse()
    }

    @After
    fun clear() {
        stopKoin()
    }
}