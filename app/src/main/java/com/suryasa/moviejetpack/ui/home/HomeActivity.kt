package com.suryasa.moviejetpack.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.suryasa.moviejetpack.R
import com.suryasa.moviejetpack.databinding.ActivityHomeBinding
import com.suryasa.moviejetpack.ui.bookmark.BookmarkActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val homePagerAdapter = HomePagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = homePagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        supportActionBar?.title = "MOOVIS"
        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_bookmark -> {
                startActivity(Intent(this, BookmarkActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}