package com.example.androidplayground.postlist.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.androidplayground.postlist.data.datasource.PostPagingSource
import com.example.androidplayground.postlist.domain.model.Post
import com.example.androidplayground.shared.domain.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPaginatedPostList @Inject constructor(
    private val postPagingSource: PostPagingSource
) : PagingUseCase<GetPaginatedPostList.Parameters, Post>() {

    override fun invoke(parameters: Parameters): Flow<PagingData<Post>> {
        return Pager(
            config = parameters.pagingConfig,
            pagingSourceFactory = { postPagingSource }
        ).flow
    }

    class Parameters(override val pagingConfig: PagingConfig) : PagingUseCase.Parameters
}