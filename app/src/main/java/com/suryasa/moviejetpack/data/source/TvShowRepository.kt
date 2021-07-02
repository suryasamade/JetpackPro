package com.suryasa.moviejetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.local.LocalDataSource
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.data.source.remote.ApiResponse
import com.suryasa.moviejetpack.data.source.remote.RemoteDataSource
import com.suryasa.moviejetpack.data.source.remote.response.TvShowResponse
import com.suryasa.moviejetpack.utils.AppExecutors
import com.suryasa.moviejetpack.vo.Resource

class TvShowRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : TvShowDataSource {
    companion object {
        @Volatile
        private var INSTANCE: TvShowRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): TvShowRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: TvShowRepository(remoteData, localDataSource, appExecutors).apply { INSTANCE = this }
            }
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundSource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean = data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> = remoteDataSource.getAllTvShows()

            public override fun saveCallResult(tvshowRespons: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShowEntity>()
                for (response in tvshowRespons) {
                    val tvshow = TvShowEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.posterUrl,
                        response.genre,
                        response.rating
                    )
                    tvshowList.add(tvshow)
                }
                localDataSource.insertTvShows(tvshowList)
            }
        }.asLiveData()
    }

    override fun setBookmarkTvShow(tvshow: TvShowEntity, state: Boolean) = appExecutors.diskIO().execute {
        localDataSource.updateTvShow(tvshow, state)
    }

    override fun getBookmarkTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkTvShows(), config).build()
    }

    override fun checkBookmarkTvShow(id: String): LiveData<Boolean> = localDataSource.checkBookmarkTvShow(id)

    override fun getTvShowDetail(tvshowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundSource<TvShowEntity, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> {
                return localDataSource.getTvShow(tvshowId)
            }

            override fun shouldFetch(data: TvShowEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> {
                return remoteDataSource.getAllTvShows()
            }

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShowEntity>()
                for (res in data) {
                    val tvshow = TvShowEntity(
                        res.id,
                        res.title,
                        res.overview,
                        res.posterUrl,
                        res.genre,
                        res.rating,
                        false
                    )
                    tvshowList.add(tvshow)
                }
                localDataSource.insertTvShows(tvshowList)
            }
        }.asLiveData()
    }
}