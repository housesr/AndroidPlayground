package com.example.androidplayground.postlist.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.androidplayground.databinding.ItemPostBinding
import com.example.androidplayground.postlist.presentation.model.PostUiModel
import com.example.androidplayground.shared.presentation.ViewBindingHolder

typealias OnPostClickListener = (postUiModel: PostUiModel) -> Unit

class PostListAdapter(
    private val onPostClickListener: OnPostClickListener
) : PagingDataAdapter<PostUiModel, PostListAdapter.PostItemViewHolder>(
    PostUiModelComparator()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        return ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let { PostItemViewHolder(it) }
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class PostItemViewHolder(
        binding: ItemPostBinding
    ) : ViewBindingHolder<ItemPostBinding>(binding) {

        fun bind(postUiModel: PostUiModel) {
            binding.textViewTitle.text = postUiModel.title
            binding.textViewBody.text = postUiModel.body
            binding.root.setOnClickListener { onPostClickListener(postUiModel) }
        }
    }

    class PostUiModelComparator : DiffUtil.ItemCallback<PostUiModel>() {

        override fun areItemsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostUiModel, newItem: PostUiModel): Boolean {
            return oldItem == newItem
        }
    }
}