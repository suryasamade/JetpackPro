package com.suryasa.moviejetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.data.source.TvShowRepository
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.utils.DataDummy
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
class DetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Resource.success(DataDummy.generateDummyMovies()[0])
    private val dummyTvShow = Resource.success(DataDummy.generateDummyTvShows()[0])
    private val movieId = dummyMovie.data?.id
    private val tvShowId = dummyTvShow.data?.id

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var tvshowRepository: TvShowRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvshowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository, tvshowRepository)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovieId(movieId!!)

        val dummy = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummy

        `when`(movieRepository.getMovieDetail(movieId)).thenReturn(movie)

        val movieEntity = viewModel.getMovie().value
        verify(movieRepository).getMovieDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummy.data?.id, movieEntity?.data?.id)
        assertEquals(dummy.data?.title, movieEntity?.data?.title)
        assertEquals(dummy.data?.posterUrl, movieEntity?.data?.posterUrl)
        assertEquals(dummy.data?.overview, movieEntity?.data?.overview)
        assertEquals(dummy.data?.genre, movieEntity?.data?.genre)
        assertEquals(dummy.data?.rating, movieEntity?.data?.rating)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShows() {
        viewModel.setSelectedTvShowId(tvShowId!!)

        val dummy = Resource.success(DataDummy.generateDummyTvShows()[0])
        val tvshow = MutableLiveData<Resource<TvShowEntity>>()
        tvshow.value = dummy

        `when`(tvshowRepository.getTvShowDetail(tvShowId)).thenReturn(tvshow)

        val tvShowEntity = viewModel.getTvShow().value
        verify(tvshowRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.data?.id, tvShowEntity?.data?.id)
        assertEquals(dummyTvShow.data?.title, tvShowEntity?.data?.title)
        assertEquals(dummyTvShow.data?.posterUrl, tvShowEntity?.data?.posterUrl)
        assertEquals(dummyTvShow.data?.overview, tvShowEntity?.data?.overview)
        assertEquals(dummyTvShow.data?.genre, tvShowEntity?.data?.genre)
        assertEquals(dummyTvShow.data?.rating, tvShowEntity?.data?.rating)

        viewModel.getTvShow().observeForever(tvshowObserver)
        verify(tvshowObserver).onChanged(dummyTvShow)
    }
}