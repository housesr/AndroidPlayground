package com.example.androidplayground.shared.domain

import com.example.androidplayground.shared.model.Error
import com.example.androidplayground.shared.model.Result
import com.example.androidplayground.shared.model.Success
import timber.log.Timber

abstract class UseCase<in P, R> {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            Success(
                execute(parameters)
            )
        } catch (e: Exception) {
            Timber.d(e)
            Error(e)
        }
    }

    abstract suspend fun execute(parameters: P): R
}