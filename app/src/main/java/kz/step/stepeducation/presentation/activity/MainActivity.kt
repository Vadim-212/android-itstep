package kz.step.stepeducation.presentation.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Room
import kz.step.stepeducation.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movies2.*
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.data.StepEducationDatabase
import kz.step.stepeducation.domain.HelperClass
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.adapter.MainPagerAdapter
import kz.step.stepeducation.presentation.adapter.MoviesPagerAdapter
import java.util.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_activity_main.adapter = MainPagerAdapter(supportFragmentManager, this)
        tablayout_activity_main.setupWithViewPager(viewpager_activity_main)
//
//        Room.databaseBuilder(
//            this,
//            StepEducationDatabase::class.java,
//            "StepEducationDatabase").allowMainThreadQueries()
//            .fallbackToDestructiveMigration() // TODO: потеря данных в базе данных, при использовании fallbackToDestructiveMigration()
//            .build().getMovieDao().initiateInsertMovies(listOf(Movie().apply {
//                title = "Movie 1"
//                description = "This is the first movie"
//                rate = 7.8F
//        }, Movie().apply {
//                title = "Movie 2"
//                description = "This is the second movie"
//                rate = 6.2F
//            }, Movie().apply {
//                title = "Movie 3"
//                description = "This is the third movie"
//                rate = 8.2F
//            }))
    }

}