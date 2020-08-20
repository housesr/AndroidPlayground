package com.example.androidplayground.shared.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = SingleLiveEvent<Exception>()
    val error: LiveData<Exception> = _error

    protected fun showLoading() {
        _loading.value = true
    }

    protected fun hideLoading() {
        _loading.value = false
    }

    protected fun showError(exception: Exception) {
        _error.value = exception
    }
}