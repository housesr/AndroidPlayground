package com.example.androidplayground.shared.presentation

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ViewBindingHolder<out T : ViewBinding>(
    protected val binding: T
) : RecyclerView.ViewHolder(binding.root)