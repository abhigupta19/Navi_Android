package com.example.navi.android.Ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navi.android.Adapter.PostAdapter
import com.example.navi.android.Model.Post
import com.example.navi.android.R
import com.example.navi.android.ViewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorText: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var postAdapter: PostAdapter
    private val postViewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUi()
        postViewModel.getPost()
        postViewModel.postLiveData.observe(this, Observer { response ->
            postAdapter.updatePostList(response as ArrayList<Post>)
            progressBar.visibility = View.GONE
            if(response.isEmpty()){
                errorText.visibility = View.VISIBLE
                errorText.text=getResources().getString(R.string.error_text_empty);

            }
            else{
                errorText.visibility = View.GONE
            }
        })
    }

    private fun setUi() {
        recyclerView = findViewById(R.id.recyclerView)
        errorText = findViewById(R.id.error_text)
        progressBar = findViewById(R.id.simpleProgressBar);
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}