package com.suryasa.moviejetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.data.source.TvShowRepository
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.vo.Resource

class DetailViewModel(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
    ) : ViewModel() {
    private lateinit var id: String

    fun setSelectedMovieId(movieId: String) {
        this.id = movieId
    }

    fun setSelectedTvShowId(tvShowId: String) {
        this.id = tvShowId
    }

    fun getMovie(): LiveData<Resource<MovieEntity>> = movieRepository.getMovieDetail(id)

    fun getTvShow(): LiveData<Resource<TvShowEntity>> = tvShowRepository.getTvShowDetail(id)

    fun checkBookmarkMovie(id: String): LiveData<Boolean> = movieRepository.checkBookmarkMovie(id)

    fun checkBookmarkTvShow(id: String): LiveData<Boolean> = tvShowRepository.checkBookmarkTvShow(id)

    fun setBookmarkMovie(movie: MovieEntity, status: Boolean) {
        movieRepository.setBookmarkMovie(movie, status)
    }

    fun setBookmarkTvShow(tvshow: TvShowEntity, status: Boolean) {
        tvShowRepository.setBookmarkTvShow(tvshow, status)
    }
}