package com.example.androidplayground.postlist.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostUiModel(
    val id: Int,
    val title: String,
    val body: String
) : Parcelable