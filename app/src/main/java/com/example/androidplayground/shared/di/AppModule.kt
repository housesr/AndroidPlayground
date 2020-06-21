package com.example.androidplayground.shared.di

import com.example.androidplayground.BuildConfig
import com.example.androidplayground.postlist.domain.GetPostList
import com.example.androidplayground.postlist.presentation.viewmodel.PostListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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

    single { GetPostList(get()) }

    viewModel { PostListViewModel(get()) }
}