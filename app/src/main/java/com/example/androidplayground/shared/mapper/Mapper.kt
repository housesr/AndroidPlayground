package com.example.androidplayground.shared.mapper

interface Mapper<I, O> {
    suspend fun map(input: I): O
}