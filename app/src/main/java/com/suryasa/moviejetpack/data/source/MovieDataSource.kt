package com.suryasa.moviejetpack.data.source

import androidx.lifecycle.LiveData
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity

interface MovieDataSource {
    fun getAllMovies(): LiveData<List<ModelEntity>>

    fun getAllTvShows(): LiveData<List<ModelEntity>>

    fun getMovieDetail(movieId: String): LiveData<ModelEntity>

    fun getTvShowDetail(tvshowId: String): LiveData<ModelEntity>
}