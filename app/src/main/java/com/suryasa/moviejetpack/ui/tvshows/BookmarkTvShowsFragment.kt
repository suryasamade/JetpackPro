package com.suryasa.moviejetpack.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.suryasa.moviejetpack.R
import com.suryasa.moviejetpack.databinding.FragmentBookmarkTvShowsBinding
import com.suryasa.moviejetpack.viewmodel.ViewModelFactory
import com.suryasa.tvshowjetpack.ui.tvshows.TvShowsAdapter

class BookmarkTvShowsFragment : Fragment() {
    private var _binding: FragmentBookmarkTvShowsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TvShowsViewModel
    private lateinit var adapter: TvShowsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBookmarkTvShowsBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding.rvTvshowBookmark)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
            adapter = TvShowsAdapter()

            viewModel.getBookmarkTvShows().observe(this, { tvshows ->
                binding.progressbar.visibility = View.GONE
                adapter.submitList(tvshows)
                adapter.notifyDataSetChanged()
            })

            binding.rvTvshowBookmark.layoutManager = LinearLayoutManager(context)
            binding.rvTvshowBookmark.setHasFixedSize(true)
            binding.rvTvshowBookmark.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvshowEntity = adapter.getSwipedData(swipedPosition)
                tvshowEntity?.let { viewModel.setBookmark(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    tvshowEntity?.let { viewModel.setBookmark(it) }
                }
                snackbar.show()
            }
        }
    })

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}