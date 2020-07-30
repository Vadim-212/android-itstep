package kz.step.stepeducation.presentation.presenters

import android.content.Context
import androidx.room.Room
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.data.StepEducationDatabase
import kz.step.stepeducation.di.component.DaggerDatabaseComponent
import kz.step.stepeducation.di.module.DatabaseModule
import kz.step.stepeducation.domain.usecase.DatabaseUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByRandomUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByTitleUseCase
import kz.step.stepeducation.presentation.contract.MoviesFragmentContract
import kz.step.stepeducation.presentation.utils.SortTypes
import javax.inject.Inject

class MoviesFragmentPresenter: MoviesFragmentContract.Presenter {
    var view: MoviesFragmentContract.View? = null
    var context: Context
    var movies: ArrayList<Movie> = ArrayList()
    @Inject lateinit var databaseUseCase: DatabaseUseCase

    constructor(context: Context) {
        this.context = context
        DaggerDatabaseComponent.builder().databaseModule(DatabaseModule(context)).build().inject(this)
    }

    override fun attach(view: MoviesFragmentContract.View) {
        this.view = view
    }

    override fun initializeData() {
        movies.clear()
        movies.addAll(databaseUseCase.initiateGetMovies())
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