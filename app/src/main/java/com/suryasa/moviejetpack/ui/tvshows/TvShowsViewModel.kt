package com.suryasa.moviejetpack.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity
import com.suryasa.moviejetpack.data.source.MovieRepository

class TvShowsViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTvShows(): LiveData<List<ModelEntity>> = movieRepository.getAllTvShows()
}