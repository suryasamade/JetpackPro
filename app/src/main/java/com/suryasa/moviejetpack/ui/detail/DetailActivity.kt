package com.suryasa.moviejetpack.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.suryasa.moviejetpack.R
import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.databinding.ActivityDetailBinding
import com.suryasa.moviejetpack.databinding.ContentDetailBinding
import com.suryasa.moviejetpack.viewmodel.ViewModelFactory
import com.suryasa.moviejetpack.vo.Status
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var contentDetailBinding: ContentDetailBinding
    private var movie: Boolean = false
    private lateinit var viewModel: DetailViewModel

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.detailContent
        setContentView(activityDetailBinding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            movie = extras.getBoolean(EXTRA_MOVIE)
            val id = extras.getString(EXTRA_DATA)
            if (id != null) {
                when (movie) {
                    true -> {
                        title(getString(R.string.detail_movie))
                        viewModel.setSelectedMovieId(id)
                        viewModel.getMovie().observe(this, { movie ->
                            if (movie != null) {
                                when (movie.status) {
                                    Status.LOADING -> activityDetailBinding.progressbar.visibility = View.VISIBLE
                                    Status.SUCCESS -> if (movie.data != null) {
                                        activityDetailBinding.progressbar.visibility = View.GONE
                                        activityDetailBinding.content.visibility = View.VISIBLE
                                        populateMovie(movie.data)
                                    }
                                    Status.ERROR -> {
                                        activityDetailBinding.progressbar.visibility = View.GONE
                                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        })
                    }
                    else -> {
                        title(getString(R.string.detail_tv_show))
                        viewModel.setSelectedTvShowId(id)
                        viewModel.getTvShow().observe(this, { tvshow ->
                            if (tvshow != null) {
                                when (tvshow.status) {
                                    Status.LOADING -> activityDetailBinding.progressbar.visibility = View.VISIBLE
                                    Status.SUCCESS -> if (tvshow.data != null) {
                                        activityDetailBinding.progressbar.visibility = View.GONE
                                        activityDetailBinding.content.visibility = View.VISIBLE
                                        populateTvShow(tvshow.data)
                                    }
                                    Status.ERROR -> {
                                        activityDetailBinding.progressbar.visibility = View.GONE
                                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        })
                    }
                }
            }
        }
    }

    private fun title(text: String) {
        supportActionBar?.title = text
    }

    private fun populateMovie(movie: MovieEntity) {
        with(contentDetailBinding) {
            textTitle.text = movie.title
            val rate = movie.rating.toFloat()/2.0
            val dec =  DecimalFormat("#,##")
            ratingNum.text = movie.rating
            ratingBar.rating = dec.format(rate).toFloat()
            genre.text = movie.genre
            overview.text = movie.overview

            Glide.with(applicationContext)
                .load(movie.posterUrl)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imgPoster)
        }

        viewModel.checkBookmarkMovie(movie.id).observe(this) {
            contentDetailBinding.bookmark.setOnClickListener{
                val movieStatus = !movie.bookmark
                viewModel.setBookmarkMovie(movie, movieStatus)
            }
            setBookmarkIcon(it)
        }
    }

    private fun populateTvShow(tvshow: TvShowEntity) {
        with(contentDetailBinding) {
            textTitle.text = tvshow.title
            val rate = tvshow.rating.toFloat()/2.0
            val dec =  DecimalFormat("#,##")
            ratingNum.text = tvshow.rating
            ratingBar.rating = dec.format(rate).toFloat()
            genre.text = tvshow.genre
            overview.text = tvshow.overview

            Glide.with(applicationContext)
                .load(tvshow.posterUrl)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(imgPoster)
        }

        viewModel.checkBookmarkTvShow(tvshow.id).observe(this) {
            contentDetailBinding.bookmark.setOnClickListener{
                val tvshowStatus = !tvshow.bookmark
                viewModel.setBookmarkTvShow(tvshow, tvshowStatus)
            }
            setBookmarkIcon(it)
        }
    }

    private fun setBookmarkIcon(state: Boolean) {
        with(contentDetailBinding) {
            if (state) bookmark.setImageResource(R.drawable.ic_bookmarked)
            else bookmark.setImageResource(R.drawable.ic_bookmark)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}