package com.example.androidplayground.commentlist.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentUiModel(
    val id: Int,
    val name: String,
    val body: String
) : Parcelable