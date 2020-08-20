package com.example.androidplayground.postlist.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplayground.R
import com.example.androidplayground.databinding.FragmentPostListBinding
import com.example.androidplayground.postlist.presentation.model.PostUiModel
import com.example.androidplayground.postlist.presentation.viewmodel.PostListViewModel
import com.example.androidplayground.shared.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListFragment : Fragment(R.layout.fragment_post_list) {

    private val binding: FragmentPostListBinding by viewBinding(FragmentPostListBinding::bind)

    private val viewModel: PostListViewModel by viewModels()

    private val listAdapter: PostListAdapter by lazy { PostListAdapter(onPostClickListener) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = listAdapter
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }

        viewModel.postList.observe(viewLifecycleOwner) {
            listAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    private val onPostClickListener = object : OnPostClickListener {
        override fun invoke(postUiModel: PostUiModel) {
            findNavController().navigate(
                PostListFragmentDirections.actionPostListFragmentToCommentListFragment(
                    postUiModel
                )
            )
        }
    }
}