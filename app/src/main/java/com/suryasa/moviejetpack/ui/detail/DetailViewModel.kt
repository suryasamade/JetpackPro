package com.suryasa.moviejetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity
import com.suryasa.moviejetpack.data.source.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelectedMovieId(movieId: String) {
        this.id = movieId
    }

    fun setSelectedTvShowId(tvShowId: String) {
        this.id = tvShowId
    }

    fun getMovies(): LiveData<ModelEntity> = movieRepository.getMovieDetail(id)

    fun getTvShows(): LiveData<ModelEntity> = movieRepository.getTvShowDetail(id)
}