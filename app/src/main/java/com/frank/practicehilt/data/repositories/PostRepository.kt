package com.frank.practicehilt.data.repositories

import com.frank.practicehilt.data.database.post.Post
import com.frank.practicehilt.data.services.PostRemoteService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postRemoteService: PostRemoteService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getPost(): List<Post> = withContext(dispatcher) {
        emptyList()
    }

}