package com.example.androidplayground.postlist

import com.example.androidplayground.postlist.data.service.PostService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val postModule = module {
    single<PostService> { get<Retrofit>().create() }
}