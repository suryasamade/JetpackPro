package com.suryasa.moviejetpack.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.vo.Resource

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()

    fun getBookmarkMovies(): LiveData<PagedList<MovieEntity>> = movieRepository.getBookmarkMovies()

    fun setBookmark(movieEntity: MovieEntity) {
        val newState = !movieEntity.bookmark
        movieRepository.setBookmarkMovie(movieEntity, newState)
    }
}