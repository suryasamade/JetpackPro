package com.suryasa.moviejetpack.ui.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.suryasa.moviejetpack.data.source.TvShowRepository
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvshowRepository: TvShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var bmObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(tvshowRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)
        val tvshows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvshows.value = dummyTvShows

        `when`(tvshowRepository.getAllTvShows()).thenReturn(tvshows)
        val tvShowsEntities = viewModel.getTvShows().value?.data
        verify(tvshowRepository).getAllTvShows()
        assertNotNull(tvShowsEntities)
        assertEquals(10, tvShowsEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }

    @Test
    fun getBookmark() {
        val dummyTvShows = pagedList
        `when`(dummyTvShows.size).thenReturn(10)
        val tvshows = MutableLiveData<PagedList<TvShowEntity>>()
        tvshows.value = dummyTvShows

        `when`(tvshowRepository.getBookmarkTvShows()).thenReturn(tvshows)
        val movieEntities = viewModel.getBookmarkTvShows().value
        verify(tvshowRepository).getBookmarkTvShows()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getBookmarkTvShows().observeForever(bmObserver)
        verify(bmObserver).onChanged(dummyTvShows)
    }
}