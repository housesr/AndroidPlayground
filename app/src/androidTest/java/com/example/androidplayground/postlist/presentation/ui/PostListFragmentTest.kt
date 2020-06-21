package com.example.androidplayground.postlist.presentation.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidplayground.postlist.data.factory.FakePostFactory
import com.example.androidplayground.postlist.data.service.FakePostService
import com.example.androidplayground.postlist.data.service.PostService
import com.example.androidplayground.postlist.fakePostModule
import com.example.androidplayground.shared.di.appModule
import com.example.androidplayground.shared.rule.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.inject
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class PostListFragmentTest : KoinTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val postService: PostService by inject()

    @Before
    fun setup() {
        loadKoinModules(listOf(appModule, fakePostModule))
    }

    @Test
    fun show_empty_when_post_list_is_empty() {
        postListRobot(postService as FakePostService) {
            postList(emptyList())
        } launch {
            isRecyclerViewNotDisplayed()
            isTextViewEmptyDisplayed()
        }
    }

    @Test
    fun do_not_show_empty_when_post_list_is_not_empty() {
        postListRobot(postService as FakePostService) {
            postList(FakePostFactory.createPostList())
        } launch {
            isRecyclerViewDisplayed()
            isTextViewEmptyNotDisplayed()
        }
    }

    @After
    fun clear() {
        unloadKoinModules(listOf(appModule, fakePostModule))
    }
}