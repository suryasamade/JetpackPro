package com.suryasa.moviejetpack.ui.bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.suryasa.moviejetpack.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBookmarkBinding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(activityBookmarkBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bookmarkPagerAdapter = BookmarkPagerAdapter(this, supportFragmentManager)
        activityBookmarkBinding.viewPager.adapter = bookmarkPagerAdapter
        activityBookmarkBinding.tabs.setupWithViewPager(activityBookmarkBinding.viewPager)

        supportActionBar?.title = "Bookmark"
        supportActionBar?.elevation = 0f
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}