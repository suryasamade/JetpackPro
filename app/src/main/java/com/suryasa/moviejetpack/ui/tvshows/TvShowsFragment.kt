package com.suryasa.moviejetpack.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.suryasa.moviejetpack.R
import com.suryasa.moviejetpack.databinding.FragmentTvShowsBinding
import com.suryasa.moviejetpack.databinding.ItemsTvShowsBinding
import com.suryasa.moviejetpack.ui.movies.MoviesAdapter
import com.suryasa.moviejetpack.utils.DataDummy
import com.suryasa.moviejetpack.viewmodel.ViewModelFactory

class TvShowsFragment : Fragment() {
    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]

            val tvShowsAdapter = TvShowsAdapter()

            fragmentTvShowsBinding.progressbar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(this, { tvShows ->
                fragmentTvShowsBinding.progressbar.visibility = View.GONE
                tvShowsAdapter.setTvShows(tvShows)
                tvShowsAdapter.notifyDataSetChanged()
            })

            with(fragmentTvShowsBinding.rvTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }
}