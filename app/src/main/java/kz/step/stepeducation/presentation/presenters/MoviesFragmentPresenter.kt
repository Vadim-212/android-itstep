package kz.step.stepeducation.presentation.presenters

import android.content.Context
import androidx.room.Room
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.data.StepEducationDatabase
import kz.step.stepeducation.domain.usecase.function.sort.SortByRandomUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByTitleUseCase
import kz.step.stepeducation.presentation.contract.MoviesFragmentContract
import kz.step.stepeducation.presentation.utils.SortTypes

class MoviesFragmentPresenter: MoviesFragmentContract.Presenter {
    var view: MoviesFragmentContract.View? = null
    var context: Context
    var movies: ArrayList<Movie> = ArrayList()
    var stepEducationDatabase: StepEducationDatabase

    constructor(context: Context) {
        this.context = context
        stepEducationDatabase = Room.databaseBuilder(
            context,
            StepEducationDatabase::class.java,
            "StepEducationDatabase").allowMainThreadQueries()
//            .fallbackToDestructiveMigration() // TODO: потеря данных в базе данных, при использовании fallbackToDestructiveMigration()
            .build()
    }

    override fun attach(view: MoviesFragmentContract.View) {
        this.view = view
    }

    override fun initializeData() {
        movies.clear()
        movies.addAll(stepEducationDatabase.getMovieDao().initiateGetMovies())
        view?.proccessData(movies)
        view?.initializeUpdateAdapter()
    }

    override fun sortMovies(sortTypes: SortTypes) {
        when(sortTypes) {
            SortTypes.NONE -> {
                return
            }
            SortTypes.RANDOM -> {
                SortByRandomUseCase.initiateSortRandom(movies)
                view?.proccessData(movies)
                view?.initializeUpdateAdapter()
            }
            SortTypes.ALPHABETICALLY -> {
                SortByTitleUseCase.initiateSortByTitle(movies)
                view?.proccessData(movies)
                view?.initializeUpdateAdapter()
            }
        }
    }

    override fun onStop() {
        this.view = null
    }
}