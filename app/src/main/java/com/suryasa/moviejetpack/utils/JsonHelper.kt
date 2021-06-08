package com.suryasa.moviejetpack.utils

import android.content.Context
import com.suryasa.moviejetpack.data.source.remote.response.ModelResponse
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

    fun loadMovies(): List<ModelResponse> {
        val list = ArrayList<ModelResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val poster_url = movie.getString("poster_url")
                val genre = movie.getString("genre")
                val rating = movie.getString("rating")

                val movieResponse = ModelResponse(id, title, overview, poster_url, genre, rating)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<ModelResponse> {
        val list = ArrayList<ModelResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("id")
                val title = tvshow.getString("title")
                val overview = tvshow.getString("overview")
                val poster_url = tvshow.getString("poster_url")
                val genre = tvshow.getString("genre")
                val rating = tvshow.getString("rating")

                val tvshowResponse = ModelResponse(id, title, overview, poster_url, genre, rating)
                list.add(tvshowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}