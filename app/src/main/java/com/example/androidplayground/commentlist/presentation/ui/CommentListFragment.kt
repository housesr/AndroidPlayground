package com.example.androidplayground.commentlist.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplayground.R
import com.example.androidplayground.commentlist.presentation.viewmodel.CommentListViewModel
import com.example.androidplayground.databinding.FragmentCommentListBinding
import com.example.androidplayground.shared.binding.viewBinding
import com.example.androidplayground.shared.extension.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentListFragment : Fragment(R.layout.fragment_comment_list) {

    private val args: CommentListFragmentArgs by navArgs()

    private val binding: FragmentCommentListBinding by viewBinding(FragmentCommentListBinding::bind)

    private val viewModel: CommentListViewModel by viewModels()

    private val listAdapter: CommentListAdapter by lazy { CommentListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.apply {
            setupWithNavController(findNavController())
            title = args.postUiModel.title
        }

        binding.recyclerView.apply {
            adapter = listAdapter
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }

        viewModel.commentList.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }

        viewModel.showEmpty.observe(viewLifecycleOwner) {
            binding.textViewEmpty.isVisible = it
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        viewModel.error.observe(viewLifecycleOwner) {
            showSnackbar(it)
        }

        viewModel.loadCommentList(args.postUiModel.id)
    }
}