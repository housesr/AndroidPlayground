package com.example.androidplayground.postlist.presentation.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.androidplayground.R
import org.hamcrest.core.IsNot.not

class PostListResultRobot {

    fun isRecyclerViewDisplayed() {
        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))
    }

    fun isRecyclerViewNotDisplayed() {
        onView(withId(R.id.recyclerView))
            .check(matches(not(isDisplayed())))
    }

    fun isTextViewEmptyDisplayed() {
        onView(withId(R.id.textViewEmpty))
            .check(matches(isDisplayed()))
    }

    fun isTextViewEmptyNotDisplayed() {
        onView(withId(R.id.textViewEmpty))
            .check(matches(not(isDisplayed())))
    }
}