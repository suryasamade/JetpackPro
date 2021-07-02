package com.suryasa.moviejetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.local.LocalDataSource
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.remote.ApiResponse
import com.suryasa.moviejetpack.data.source.remote.RemoteDataSource
import com.suryasa.moviejetpack.data.source.remote.response.MovieResponse
import com.suryasa.moviejetpack.utils.AppExecutors
import com.suryasa.moviejetpack.vo.Resource

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : MovieDataSource {
    companion object {
        @Volatile
        private var INSTANCE: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): MovieRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MovieRepository(remoteData, localDataSource, appExecutors).apply { INSTANCE = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundSource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovies()

            public override fun saveCallResult(movieRespons: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieRespons) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.posterUrl,
                        response.genre,
                        response.rating
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun setBookmarkMovie(movie: MovieEntity, state: Boolean) = appExecutors.diskIO().execute {
        localDataSource.updateMovie(movie, state)
    }

    override fun getBookmarkMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkMovies(), config).build()
    }

    override fun checkBookmarkMovie(id: String): LiveData<Boolean> = localDataSource.checkBookmarkMovie(id)

    override fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundSource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getMovie(movieId)
            }

            override fun shouldFetch(data: MovieEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (res in data) {
                    val movie = MovieEntity(
                        res.id,
                        res.title,
                        res.overview,
                        res.posterUrl,
                        res.genre,
                        res.rating,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }
}