package com.suryasa.moviejetpack.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.TvShowRepository
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.vo.Resource

class TvShowsViewModel(private val tvshowRepository: TvShowRepository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = tvshowRepository.getAllTvShows()

    fun getBookmarkTvShows(): LiveData<PagedList<TvShowEntity>> = tvshowRepository.getBookmarkTvShows()

    fun setBookmark(tvshowEntity: TvShowEntity) {
        val newState = !tvshowEntity.bookmark
        tvshowRepository.setBookmarkTvShow(tvshowEntity, newState)
    }
}