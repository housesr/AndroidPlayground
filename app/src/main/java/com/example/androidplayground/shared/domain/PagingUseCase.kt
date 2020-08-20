package com.example.androidplayground.shared.domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

abstract class PagingUseCase<P : PagingUseCase.Parameters, R : Any> {

    abstract operator fun invoke(parameters: P): Flow<PagingData<R>>

    interface Parameters {
        val pagingConfig: PagingConfig
    }
}