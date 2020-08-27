package com.example.androidplayground.shared.domain

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import timber.log.Timber

abstract class UseCase<in P, R> {

    suspend operator fun invoke(parameters: P): Result<R, Exception> {
        return try {
            Ok(
                execute(parameters)
            )
        } catch (e: Exception) {
            Timber.d(e)
            Err(e)
        }
    }

    protected abstract suspend fun execute(parameters: P): R
}