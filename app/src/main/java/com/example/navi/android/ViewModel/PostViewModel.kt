package com.example.navi.android.ViewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navi.android.Model.Post
import com.example.navi.android.Repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel @ViewModelInject constructor(private val postRepository: PostRepository) :
    ViewModel() {
    val postLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            postRepository.getPost()
                .catch { e ->
                    Log.d("error_PostViewModel", "getData: ${e.message}")
                }.collect { response ->
                    postLiveData.value = response
                }

        }
    }
}