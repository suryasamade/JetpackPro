package com.suryasa.moviejetpack.utils

import android.content.Context
import com.suryasa.moviejetpack.data.source.remote.response.MovieResponse
import com.suryasa.moviejetpack.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val posterUrl = movie.getString("posterUrl")
                val genre = movie.getString("genre")
                val rating = movie.getString("rating")

                val movieResponse = MovieResponse(id, title, overview, posterUrl, genre, rating)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("id")
                val title = tvshow.getString("title")
                val overview = tvshow.getString("overview")
                val posterUrl = tvshow.getString("posterUrl")
                val genre = tvshow.getString("genre")
                val rating = tvshow.getString("rating")

                val tvshowResponse = TvShowResponse(id, title, overview, posterUrl, genre, rating)
                list.add(tvshowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadMovieDetail(movieId: String): MovieResponse {
        val fileName = String.format("Movie_%s.json", movieId)
        var movieResponse: MovieResponse? = null
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)

                val title = responseObject.getString("title")
                val overview = responseObject.getString("overview")
                val posterUrl = responseObject.getString("posterUrl")
                val genre = responseObject.getString("genre")
                val rating = responseObject.getString("rating")
                movieResponse = MovieResponse(movieId, title, overview, posterUrl, genre, rating)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieResponse as MovieResponse
    }

    fun loadTvShowDetail(tvshowId: String): TvShowResponse {
        val fileName = String.format("TvShow_%s.json", tvshowId)
        var tvshowResponse: TvShowResponse? = null
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)

                val title = responseObject.getString("title")
                val overview = responseObject.getString("overview")
                val posterUrl = responseObject.getString("posterUrl")
                val genre = responseObject.getString("genre")
                val rating = responseObject.getString("rating")
                tvshowResponse = TvShowResponse(tvshowId, title, overview, posterUrl, genre, rating)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvshowResponse as TvShowResponse
    }
}