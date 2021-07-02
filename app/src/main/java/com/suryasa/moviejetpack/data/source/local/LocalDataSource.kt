package com.suryasa.moviejetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.db.BookmarkDao

class LocalDataSource private constructor(private val mBookmarkDao: BookmarkDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(bookmarkDao: BookmarkDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(bookmarkDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mBookmarkDao.getMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mBookmarkDao.getTvShows()

    fun getMovie(id: String): LiveData<MovieEntity> = mBookmarkDao.getMovie(id)

    fun getTvShow(id: String): LiveData<TvShowEntity> = mBookmarkDao.getTvShow(id)

    fun insertMovies(movies: List<MovieEntity>) = mBookmarkDao.insertMovies(movies)

    fun insertTvShows(tvshows: List<TvShowEntity>) = mBookmarkDao.insertTvShows(tvshows)

    fun getBookmarkMovies(): DataSource.Factory<Int, MovieEntity> = mBookmarkDao.getBookmarkMovies()

    fun getBookmarkTvShows(): DataSource.Factory<Int, TvShowEntity> = mBookmarkDao.getBookmarkTvShows()

    fun checkBookmarkMovie(id: String): LiveData<Boolean> = mBookmarkDao.checkMovieBookmark(id)

    fun checkBookmarkTvShow(id: String): LiveData<Boolean> = mBookmarkDao.checkTvShowBookmark(id)

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.bookmark = newState
        mBookmarkDao.updateBookmarkMovie(movie)
    }

    fun updateTvShow(tvshow: TvShowEntity, newState: Boolean) {
        tvshow.bookmark = newState
        mBookmarkDao.updateBookmarkTvShow(tvshow)
    }
}