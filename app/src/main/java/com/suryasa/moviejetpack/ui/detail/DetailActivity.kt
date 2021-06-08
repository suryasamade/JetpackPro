package com.suryasa.moviejetpack.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.suryasa.moviejetpack.R
import com.suryasa.moviejetpack.data.source.local.entity.ModelEntity
import com.suryasa.moviejetpack.databinding.ActivityDetailBinding
import com.suryasa.moviejetpack.databinding.ContentDetailBinding
import com.suryasa.moviejetpack.viewmodel.ViewModelFactory
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var contentDetailBinding: ContentDetailBinding
    private var movie: Boolean = false
    private var TAG = DetailActivity::class.java.simpleName

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
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras

        if (extras != null) {
            movie = extras.getBoolean(EXTRA_MOVIE)
            val id = extras.getString(EXTRA_DATA)
            if (id != null) {
                activityDetailBinding.progressbar.visibility = View.VISIBLE
                activityDetailBinding.content.visibility = View.INVISIBLE

                when (movie) {
                    true -> {
                        title("Detail Movie")
                        viewModel.setSelectedMovieId(id)
                        viewModel.getMovies().observe(this, { movie ->
                            activityDetailBinding.progressbar.visibility = View.GONE
                            activityDetailBinding.content.visibility = View.VISIBLE
                            populateMovie(movie)
                        })
                    }
                    else -> {
                        title("Detail TV Show")
                        viewModel.setSelectedTvShowId(id)
                        viewModel.getTvShows().observe(this, { tvshow ->
                            activityDetailBinding.progressbar.visibility = View.GONE
                            activityDetailBinding.content.visibility = View.VISIBLE
                            populateMovie(tvshow)
                        })
                    }
                }
            }
        }
    }

    private fun title(text: String) {
        supportActionBar?.title = text
    }

    private fun populateMovie(modelEntity: ModelEntity) {
        contentDetailBinding.textTitle.text = modelEntity.title
        val rate = modelEntity.rating.toFloat()/2.0
        val dec =  DecimalFormat("#,##")
        contentDetailBinding.ratingNum.text = modelEntity.rating
        contentDetailBinding.ratingBar.rating = dec.format(rate).toFloat()
        contentDetailBinding.genre.text = modelEntity.genre
        contentDetailBinding.overview.text = modelEntity.overview
        Glide.with(this)
            .load(modelEntity.poster_url)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(contentDetailBinding.imgPoster)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}