package com.suryasa.moviejetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.suryasa.moviejetpack.data.source.local.LocalDataSource
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
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

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val movieId = movieResponses[0].id

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getBookmarkMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getBookmarkMovies()).thenReturn(dataSourceFactory)
        movieRepository.getBookmarkMovies()

        val movieEntities = PagedListUtil.mockPagedList(DataDummy.generateBookmarkMovie())
        verify(local).getBookmarkMovies()
        assertNotNull(movieEntities)
        assertEquals(1, movieEntities.size)
    }

    @Test
    fun checkBookmarkMovie() {
        val DBState = MutableLiveData<Boolean>()
        DBState.value = movieResponses[0].bookmark
        `when`(local.checkBookmarkMovie(movieId)).thenReturn(DBState)

        val RepoState = LiveDataTestUtil.getValue(movieRepository.checkBookmarkMovie(movieId))

        verify(local).checkBookmarkMovie(movieId)
        assertTrue(RepoState)
        assertEquals(DBState.value, RepoState)
    }
    
    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateDummyDetailMovie(movieId)
        `when`(local.getMovie(movieId)).thenReturn(dummyMovie)

        val resultMovieDetail = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieId))
        verify(local).getMovie(movieId)
        assertNotNull(resultMovieDetail)
        assertEquals(movieResponses[0].id, resultMovieDetail.data?.id)
        assertEquals(movieResponses[0].title, resultMovieDetail.data?.title)
        assertEquals(movieResponses[0].overview, resultMovieDetail.data?.overview)
        assertEquals(movieResponses[0].posterUrl, resultMovieDetail.data?.posterUrl)
        assertEquals(movieResponses[0].genre, resultMovieDetail.data?.genre)
        assertEquals(movieResponses[0].rating, resultMovieDetail.data?.rating)
    }
}