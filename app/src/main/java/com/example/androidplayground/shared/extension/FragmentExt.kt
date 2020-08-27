package com.example.androidplayground.shared.extension

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(exception: Exception, length: Int = Snackbar.LENGTH_SHORT) {
    val view = view
    val message = exception.message
    if (view != null && message != null) {
        Snackbar.make(view, message, length).show()
    }
}