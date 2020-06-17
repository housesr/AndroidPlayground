package com.example.androidplayground.core.di

import com.example.androidplayground.BuildConfig
import com.example.androidplayground.postlist.data.repository.PostListRepository
import com.example.androidplayground.postlist.data.repository.PostService
import com.example.androidplayground.postlist.presentation.viewmodel.PostListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val appModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder().apply {

            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)

            if (BuildConfig.DEBUG) {
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }
        }.build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
    }

    single<PostService> { get<Retrofit>().create() }

    single { PostListRepository(get()) }

    viewModel { PostListViewModel(get()) }
}