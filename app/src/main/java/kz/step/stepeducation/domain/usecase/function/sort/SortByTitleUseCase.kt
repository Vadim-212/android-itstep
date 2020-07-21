package kz.step.stepeducation.domain.usecase.function.sort

import kz.step.stepeducation.data.Movie

class SortByTitleUseCase {
    companion object {
        fun initiateSortByTitle(movies: ArrayList<Movie>): ArrayList<Movie> {
            return movies.apply { sortBy { movie -> movie.title } }
        }
    }
}