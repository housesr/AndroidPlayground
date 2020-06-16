package com.example.androidplayground.postlist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplayground.databinding.ItemPostBinding
import com.example.androidplayground.postlist.data.model.Post

class PostListAdapter : ListAdapter<Post, PostListAdapter.PostItemViewHolder>(PostItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        return ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let { PostItemViewHolder(it) }
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostItemViewHolder(
        private val binding: ItemPostBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.textViewTitle.text = post.title
            binding.textViewBody.text = post.body
            binding.root.setOnClickListener { }
        }
    }

    class PostItemCallback : DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}