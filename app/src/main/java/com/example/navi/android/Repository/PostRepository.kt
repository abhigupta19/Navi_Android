package com.example.navi.android.Repository

import com.example.navi.android.Model.Post
import com.example.navi.android.Network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {

    fun getPost(): Flow<List<Post>> = flow {
        val response = apiService.getPosts()
        emit(response)
    }.flowOn(Dispatchers.IO)
}