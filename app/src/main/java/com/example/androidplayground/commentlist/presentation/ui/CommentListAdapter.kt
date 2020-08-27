package com.example.androidplayground.commentlist.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.androidplayground.commentlist.presentation.model.CommentUiModel
import com.example.androidplayground.databinding.ItemCommentBinding
import com.example.androidplayground.shared.presentation.ViewBindingHolder

class CommentListAdapter : ListAdapter<CommentUiModel, CommentListAdapter.CommentItemViewHolder>(
    CommentUiModelComparator()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemViewHolder {
        return CommentItemViewHolder(
            ItemCommentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CommentItemViewHolder(
        binding: ItemCommentBinding
    ) : ViewBindingHolder<ItemCommentBinding>(binding) {

        fun bind(commentEntity: CommentUiModel) {
            binding.textViewName.text = commentEntity.name
            binding.textViewBody.text = commentEntity.body
        }
    }

    class CommentUiModelComparator : DiffUtil.ItemCallback<CommentUiModel>() {

        override fun areItemsTheSame(oldItem: CommentUiModel, newItem: CommentUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CommentUiModel, newItem: CommentUiModel): Boolean {
            return oldItem == newItem
        }
    }
}