package com.example.androidplayground.commentlist.data.model


import com.example.androidplayground.commentlist.domain.model.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentEntity(
    @Json(name = "postId") val postId: Int?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "email") val email: String?,
    @Json(name = "body") val body: String?
) {

    suspend fun toComment(): Comment =
        Comment(
            postId = postId!!,
            id = id!!,
            name = name ?: "",
            email = email ?: "",
            body = body ?: ""
        )
}