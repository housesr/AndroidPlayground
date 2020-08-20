package com.example.androidplayground.postlist.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplayground.databinding.FragmentPostListBinding
import com.example.androidplayground.postlist.presentation.viewmodel.PostListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding

    private val viewModel: PostListViewModel by viewModels()
    private val listAdapter: PostListAdapter by lazy { PostListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = listAdapter
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }

        viewModel.postList.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }

        viewModel.showEmpty.observe(viewLifecycleOwner) {
            binding.recyclerView.isVisible = it.not()
            binding.textViewEmpty.isVisible = it
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        viewModel.loadPostList()
    }
}