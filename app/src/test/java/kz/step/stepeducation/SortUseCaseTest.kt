package kz.step.stepeducation

import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.domain.usecase.function.sort.SortByTitleUseCase
import kz.step.stepeducation.domain.usecase.function.sort.SortByRandomUseCase
import org.junit.Test

class SortUseCaseTest : BaseUnitTest() {
    lateinit var moviesArray: ArrayList<Movie>

    override fun beforeTest() {
        moviesArray = arrayListOf(Movie().apply {
            id = 1
            title = "Movie 1"
            description = "This is first movie."
            rate = 7.6F
            image = ByteArray(0)
        },Movie().apply {
            id = 2
            title = "Movie 2"
            description = "This is second movie."
            rate = 8.2F
            image = ByteArray(0)
        },Movie().apply {
            id = 1
            title = "Movie 3"
            description = "This is third movie."
            rate = 6.5F
            image = ByteArray(0)
        })
    }

    override fun afterTest() {}

    @Test
    fun initiateTest(){
        assert(SortByTitleUseCase.initiateSortByTitle(moviesArray.toMutableList() as ArrayList<Movie>) == moviesArray)
        assert(SortByRandomUseCase.initiateSortRandom(moviesArray.toMutableList() as ArrayList<Movie>) != moviesArray)
    }
}