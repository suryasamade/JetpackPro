package com.suryasa.moviejetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>>

    fun setBookmarkMovie(movie: MovieEntity, state: Boolean)

    fun getBookmarkMovies(): LiveData<PagedList<MovieEntity>>

    fun checkBookmarkMovie(id: String): LiveData<Boolean>
}