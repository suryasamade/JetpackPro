package com.suryasa.moviejetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.vo.Resource

interface TvShowDataSource {
    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getTvShowDetail(movieId: String): LiveData<Resource<TvShowEntity>>

    fun setBookmarkTvShow(tvshow: TvShowEntity, state: Boolean)

    fun getBookmarkTvShows(): LiveData<PagedList<TvShowEntity>>

    fun checkBookmarkTvShow(id: String): LiveData<Boolean>
}