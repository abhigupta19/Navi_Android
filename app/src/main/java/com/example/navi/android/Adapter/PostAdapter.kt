package com.example.navi.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navi.android.Model.Post
import com.example.navi.android.R
import kotlinx.android.synthetic.main.item_list.view.*

class PostAdapter(var context: Context, var Post: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.PullListRequestViewHolder>() {

    fun updatePostList(newPost: List<Post>) {
        Post.clear()
        Post.addAll(newPost)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = PullListRequestViewHolder(
        context,
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

    override fun getItemCount() = Post.size

    override fun onBindViewHolder(holder: PullListRequestViewHolder, position: Int) {
        holder.bind(Post[position])
    }

    class PullListRequestViewHolder(var context: Context, view: View) :
        RecyclerView.ViewHolder(view) {
        private val title = view.title
        private val created_date = view.created_date
        private val closed_date = view.closed_date
        private val imageView = view.imageView
        private val username = view.user


        fun bind(Post: Post) {
            title.text = "Title:".plus(Post.title)
            created_date.text = Post.created_date
            closed_date.text = Post.closed_date
            username.text = Post.user.name
            Glide.with(context)
                .load(Post.user.avatar_url)
                .into(imageView)

        }
    }


}