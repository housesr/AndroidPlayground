package com.example.androidplayground.postlist.presentation.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import androidx.test.core.app.launchActivity
import com.example.androidplayground.MainActivity
import com.example.androidplayground.postlist.domain.usecase.GetPaginatedPostList
import com.example.androidplayground.shared.rule.MainCoroutineRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class PostEntityListFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Inject
    lateinit var getPaginatedPostList: GetPaginatedPostList

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Ignore
    @Test
    fun show_empty_when_post_list_is_empty() {
        coEvery { getPaginatedPostList(any()) } returns flow {
            emit(
                PagingData.empty()
            )
        }

        launchActivity<MainActivity>()

//        postListRobot {
//            postList(emptyList())
//        } launch {
//            isRecyclerViewNotDisplayed()
//            isTextViewEmptyDisplayed()
//        }
    }

    @Ignore
    @Test
    fun do_not_show_empty_when_post_list_is_not_empty() {
//        postListRobot {
//            postList(FakePostFactory.createPostList())
//        } launch {
//            isRecyclerViewDisplayed()
//            isTextViewEmptyNotDisplayed()
//        }
    }
}