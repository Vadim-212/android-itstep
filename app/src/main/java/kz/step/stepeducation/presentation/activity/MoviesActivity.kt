package kz.step.stepeducation.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_movies2.*
import kz.step.stepeducation.R
import kz.step.stepeducation.presentation.adapter.MoviesPagerAdapter


class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies2)

        viewpager_activity_movies.adapter = MoviesPagerAdapter(supportFragmentManager, this)
        tablayout_activity_movies.setupWithViewPager(viewpager_activity_movies)
    }
}