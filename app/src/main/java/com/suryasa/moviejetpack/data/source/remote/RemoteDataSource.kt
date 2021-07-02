package com.suryasa.moviejetpack.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suryasa.moviejetpack.data.source.remote.response.MovieResponse
import com.suryasa.moviejetpack.data.source.remote.response.TvShowResponse
import com.suryasa.moviejetpack.utils.EspressoIdlingResources
import com.suryasa.moviejetpack.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var INSTANCE: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RemoteDataSource(helper).apply { INSTANCE = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResources.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            resultTvShows.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResources.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShows
    }

    fun getMovieDetail(movieId: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovieDetail(movieId))
            EspressoIdlingResources.decrement()
                    }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTvShowDetail(tvshowId: String): LiveData<ApiResponse<TvShowResponse>> {
        EspressoIdlingResources.increment()
        val resultTvShow = MutableLiveData<ApiResponse<TvShowResponse>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShowDetail(tvshowId))
            EspressoIdlingResources.decrement()
                    }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }
}