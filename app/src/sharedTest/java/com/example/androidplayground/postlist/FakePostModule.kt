package com.example.androidplayground.postlist

import com.example.androidplayground.postlist.data.service.FakePostService
import com.example.androidplayground.postlist.data.service.PostService
import org.koin.dsl.module

val fakePostModule = module {
    single<PostService>(override = true) { FakePostService() }
}