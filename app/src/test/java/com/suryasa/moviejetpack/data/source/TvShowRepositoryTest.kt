package com.suryasa.moviejetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.suryasa.moviejetpack.data.source.local.LocalDataSource
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.data.source.remote.RemoteDataSource
import com.suryasa.moviejetpack.utils.AppExecutors
import com.suryasa.moviejetpack.utils.DataDummy
import com.suryasa.moviejetpack.utils.LiveDataTestUtil
import com.suryasa.moviejetpack.utils.PagedListUtil
import com.suryasa.moviejetpack.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class TvShowRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val tvshowRepository = FakeTvShowRepository(remote, local, appExecutors)

    private val tvshowResponses = DataDummy.generateDummyTvShows()
    private val tvshowId = tvshowResponses[0].id

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        tvshowRepository.getAllTvShows()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun getBookmarkTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getBookmarkTvShows()).thenReturn(dataSourceFactory)
        tvshowRepository.getBookmarkTvShows()

        val tvshowEntities = PagedListUtil.mockPagedList(DataDummy.generateBookmarkTvShow())
        verify(local).getBookmarkTvShows()
        assertNotNull(tvshowEntities)
        assertEquals(1, tvshowEntities.size)
    }

    @Test
    fun checkBookmarkMovie() {
        val DBState = MutableLiveData<Boolean>()
        DBState.value = tvshowResponses[0].bookmark
        `when`(local.checkBookmarkTvShow(tvshowId)).thenReturn(DBState)

        val RepoState = LiveDataTestUtil.getValue(tvshowRepository.checkBookmarkTvShow(tvshowId))

        verify(local).checkBookmarkTvShow(tvshowId)
        assertTrue(RepoState)
        assertEquals(DBState.value, RepoState)
    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = DataDummy.generateDummyDetailTvShow(tvshowId)
        `when`(local.getTvShow(tvshowId)).thenReturn(dummyTvShow)

        val resultTvShowDetail = LiveDataTestUtil.getValue(tvshowRepository.getTvShowDetail(tvshowId))
        verify(local).getTvShow(tvshowId)
        assertNotNull(resultTvShowDetail)
        assertEquals(tvshowResponses[0].id, resultTvShowDetail.data?.id)
        assertEquals(tvshowResponses[0].title, resultTvShowDetail.data?.title)
        assertEquals(tvshowResponses[0].overview, resultTvShowDetail.data?.overview)
        assertEquals(tvshowResponses[0].posterUrl, resultTvShowDetail.data?.posterUrl)
        assertEquals(tvshowResponses[0].genre, resultTvShowDetail.data?.genre)
        assertEquals(tvshowResponses[0].rating, resultTvShowDetail.data?.rating)
    }
}