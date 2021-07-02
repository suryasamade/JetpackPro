package com.suryasa.moviejetpack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.data.source.TvShowRepository
import com.suryasa.moviejetpack.di.Injection
import com.suryasa.moviejetpack.ui.detail.DetailViewModel
import com.suryasa.moviejetpack.ui.movies.MoviesViewModel
import com.suryasa.moviejetpack.ui.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(
    private val mMovieRepository: MovieRepository,
    private val mTvShowRepository: TvShowRepository
    ) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideMovieRepository(context),
                    Injection.provideTvShowRepository(context)).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(mTvShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mMovieRepository, mTvShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}