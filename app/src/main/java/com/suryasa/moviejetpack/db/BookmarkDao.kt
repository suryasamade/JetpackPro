package com.suryasa.moviejetpack.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM movieentities")
//    fun getMovies(): LiveData<List<MovieEntity>>
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities")
//    fun getTvShows(): LiveData<List<TvShowEntity>>
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getMovie(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE id = :id")
    fun getTvShow(id: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM movieentities WHERE bookmark = 1")
//    fun getBookmarkMovies(): LiveData<List<MovieEntity>>
    fun getBookmarkMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE bookmark = 1")
//    fun getBookmarkTvShows(): LiveData<List<TvShowEntity>>
    fun getBookmarkTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movieEntity: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvshowEntity: List<TvShowEntity>)

    @Update
    fun updateBookmarkMovie(movieEntity: MovieEntity)

    @Update
    fun updateBookmarkTvShow(tvshowEntity: TvShowEntity)

    @Query("SELECT bookmark FROM movieentities WHERE id = :id")
    fun checkMovieBookmark(id: String): LiveData<Boolean>

    @Query("SELECT bookmark FROM tvshowentities WHERE id = :id")
    fun checkTvShowBookmark(id: String): LiveData<Boolean>
}