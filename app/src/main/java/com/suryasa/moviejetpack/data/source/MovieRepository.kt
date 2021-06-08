package com.suryasa.moviejetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity
import com.suryasa.moviejetpack.data.source.remote.RemoteDataSource
import com.suryasa.moviejetpack.data.source.remote.response.ModelResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<ModelEntity>> {
        val movieResults = MutableLiveData<List<ModelEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<ModelResponse>) {
                val movieList = ArrayList<ModelEntity>()
                for (response in movieResponses) {
                    val movie = ModelEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.poster_url,
                            response.genre,
                            response.rating
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<ModelEntity>> {
        val tvshowResults = MutableLiveData<List<ModelEntity>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvshowResponses: List<ModelResponse>) {
                val tvshowList = ArrayList<ModelEntity>()
                for (response in tvshowResponses) {
                    val tvshow = ModelEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.poster_url,
                            response.genre,
                            response.rating
                    )
                    tvshowList.add(tvshow)
                }
                tvshowResults.postValue(tvshowList)
            }
        })
        return tvshowResults
    }

    override fun getMovieDetail(movieId: String): LiveData<ModelEntity> {
        val movieResult = MutableLiveData<ModelEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<ModelResponse>) {
                lateinit var movie: ModelEntity
                for (response in movieResponses) {
                    if (response.id == movieId) {
                        movie = ModelEntity(
                                response.id,
                                response.title,
                                response.overview,
                                response.poster_url,
                                response.genre,
                                response.rating
                        )
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    override fun getTvShowDetail(tvshowId: String): LiveData<ModelEntity> {
        val tvshowResult = MutableLiveData<ModelEntity>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvshowResponses: List<ModelResponse>) {
                lateinit var tvshow: ModelEntity
                for (response in tvshowResponses) {
                    if (response.id == tvshowId) {
                        tvshow = ModelEntity(
                                response.id,
                                response.title,
                                response.overview,
                                response.poster_url,
                                response.genre,
                                response.rating
                        )
                    }
                }
                tvshowResult.postValue(tvshow)
            }
        })
        return tvshowResult
    }
}