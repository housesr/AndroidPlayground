package com.example.androidplayground.shared.model

sealed class Result<T>

data class Success<T>(val data: T) : Result<T>()
data class Error<T>(val exception: Exception) : Result<T>()

fun <T> Result<T>.getOrDefault(default: T): T {
    return when (this) {
        is Success -> data
        is Error -> default
    }
}