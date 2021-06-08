package com.suryasa.moviejetpack.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity
import com.suryasa.moviejetpack.data.source.MovieRepository

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<List<ModelEntity>> = movieRepository.getAllMovies()
}