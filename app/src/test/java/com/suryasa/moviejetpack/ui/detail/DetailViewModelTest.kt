package com.suryasa.moviejetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity
import com.suryasa.moviejetpack.utils.DataDummy
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
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<ModelEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getTvShows() {
        viewModel.setSelectedTvShowId(tvShowId)

        val tvshow = MutableLiveData<ModelEntity>()
        tvshow.value = dummyTvShow

        `when`(movieRepository.getTvShowDetail(tvShowId)).thenReturn(tvshow)
        val tvShowEntity = viewModel.getTvShows().value as ModelEntity
        verify(movieRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.poster_url, tvShowEntity.poster_url)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.rating, tvShowEntity.rating)

        viewModel.getTvShows().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyTvShow)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovieId(movieId)

        val movie = MutableLiveData<ModelEntity>()
        movie.value = dummyMovie

        `when`(movieRepository.getMovieDetail(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovies().value as ModelEntity
        verify(movieRepository).getMovieDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.poster_url, movieEntity.poster_url)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.rating, movieEntity.rating)

        viewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }
}