package com.example.androidplayground.postlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplayground.databinding.FragmentPostListBinding
import com.example.androidplayground.postlist.data.model.Post

class PostListFragment : Fragment() {

    private lateinit var binding: FragmentPostListBinding

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

        listAdapter.submitList(
            listOf(
                Post(1, 1, "title", "body"),
                Post(1, 2, "title2", "body2")
            )
        )
    }
}