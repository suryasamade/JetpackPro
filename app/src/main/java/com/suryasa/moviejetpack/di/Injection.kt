package com.suryasa.moviejetpack.di

import android.content.Context
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.data.source.TvShowRepository
import com.suryasa.moviejetpack.data.source.local.LocalDataSource
import com.suryasa.moviejetpack.data.source.remote.RemoteDataSource
import com.suryasa.moviejetpack.db.BookmarkDatabase
import com.suryasa.moviejetpack.utils.AppExecutors
import com.suryasa.moviejetpack.utils.JsonHelper

object Injection {
    fun provideMovieRepository(context: Context): MovieRepository {
        val database = BookmarkDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.bookmarkDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTvShowRepository(context: Context): TvShowRepository {
        val database = BookmarkDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.bookmarkDao())
        val appExecutors = AppExecutors()

        return TvShowRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}