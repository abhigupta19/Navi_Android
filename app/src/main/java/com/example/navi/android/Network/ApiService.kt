package com.example.navi.android.Network

import com.example.navi.android.Model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("repos/abhigupta19/Dragger-Hilt/pulls?state=closed")
    suspend fun getPosts(): List<Post>
}