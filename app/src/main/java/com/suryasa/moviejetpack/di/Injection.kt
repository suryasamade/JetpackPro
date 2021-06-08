package com.suryasa.moviejetpack.di

import android.content.Context
import com.suryasa.moviejetpack.data.source.MovieRepository
import com.suryasa.moviejetpack.data.source.remote.RemoteDataSource
import com.suryasa.moviejetpack.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }
}