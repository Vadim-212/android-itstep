package kz.step.stepeducation.domain.usecase.function.sort

class SortByRandomUseCase {
    companion object {
        fun <T> initiateSortRandom(array: ArrayList<T>): ArrayList<T> {
            return array.apply { shuffle() }
        }
    }
}