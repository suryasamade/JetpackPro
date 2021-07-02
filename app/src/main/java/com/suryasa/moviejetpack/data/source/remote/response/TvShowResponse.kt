package com.suryasa.moviejetpack.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(
    var id: String,
    var title: String,
    var overview: String,
    var posterUrl: String,
    var genre: String,
    var rating: String
):Parcelable
