package kz.step.stepeducation.presentation.contract

import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.presentation.base.BaseContract
import kz.step.stepeducation.presentation.utils.SortTypes

interface MoviesFragmentContract {
    interface View: BaseContract.BaseView {
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initializeUpdateAdapter()

        fun proccessData(movies: ArrayList<Movie>)
    }

    interface Presenter: BaseContract.BasePresenter<View> {
        fun initializeData()

        fun sortMovies(sortTypes: SortTypes)
    }
}